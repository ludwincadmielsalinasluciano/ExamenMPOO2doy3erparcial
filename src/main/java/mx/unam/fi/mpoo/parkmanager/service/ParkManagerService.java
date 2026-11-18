package mx.unam.fi.mpoo.parkmanager.service;

import mx.unam.fi.mpoo.parkmanager.dto.CompraRequest;
import mx.unam.fi.mpoo.parkmanager.dto.CompraResponse;
import mx.unam.fi.mpoo.parkmanager.dto.DescuentoRequest;
import mx.unam.fi.mpoo.parkmanager.dto.DescuentoResponse;
import mx.unam.fi.mpoo.parkmanager.exception.SolicitudInvalidaException;
import mx.unam.fi.mpoo.parkmanager.exception.TipoBoletoInvalidoException;
import mx.unam.fi.mpoo.parkmanager.model.Boleto;
import mx.unam.fi.mpoo.parkmanager.model.BoletoAlumno;
import mx.unam.fi.mpoo.parkmanager.model.BoletoGeneral;
import mx.unam.fi.mpoo.parkmanager.model.BoletoPaseAnual;
import mx.unam.fi.mpoo.parkmanager.model.BoletoProfesor;
import mx.unam.fi.mpoo.parkmanager.model.RegistroCompra;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkManagerService {

    private final Map<String, Boleto> catalogoModalidades;
    private final List<RegistroCompra> historialCompras;
    private BigDecimal ingresosAcumulados;
    private int boletosVendidosAcumulados;

    public ParkManagerService() {
        this.catalogoModalidades = new LinkedHashMap<>();
        registrarModalidad(new BoletoGeneral());
        registrarModalidad(new BoletoPaseAnual());
        registrarModalidad(new BoletoAlumno());
        registrarModalidad(new BoletoProfesor());

        this.historialCompras = new ArrayList<>();
        this.ingresosAcumulados = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        this.boletosVendidosAcumulados = 0;
    }

    private void registrarModalidad(Boleto boleto) {
        this.catalogoModalidades.put(boleto.getTipo(), boleto);
    }

    public synchronized DescuentoResponse configurarDescuento(String tipo, DescuentoRequest request) {
        if (request == null || request.getPorcentaje() == null) {
            throw new SolicitudInvalidaException("El campo 'porcentaje' es obligatorio");
        }

        Boleto boleto = obtenerBoletoValido(tipo);
        boleto.configurarDescuento(request.getPorcentaje());

        return new DescuentoResponse(
                boleto.getTipo(),
                boleto.getDescuentoPorcentaje(),
                "Descuento configurado"
        );
    }

    public synchronized DescuentoResponse eliminarDescuento(String tipo) {
        Boleto boleto = obtenerBoletoValido(tipo);
        boleto.desactivarDescuento();

        return new DescuentoResponse(
                boleto.getTipo(),
                boleto.getDescuentoPorcentaje(),
                "Descuento desactivado"
        );
    }

    public synchronized CompraResponse registrarCompra(CompraRequest request) {
        if (request == null || request.getTipo() == null || request.getTipo().isBlank() || request.getCantidad() == null) {
            throw new SolicitudInvalidaException("Los campos 'tipo' y 'cantidad' son obligatorios");
        }

        Boleto boleto = obtenerBoletoValido(request.getTipo());
        int cantidad = request.getCantidad();

        BigDecimal totalCompra = boleto.calcularTotalCompra(cantidad);
        BigDecimal precioBase = boleto.obtenerPrecioBase();
        int descuentoAplicado = boleto.getDescuentoPorcentaje();
        BigDecimal precioUnitarioFinal = boleto.calcularPrecioUnitarioFinal();

        RegistroCompra registro = new RegistroCompra(
                boleto.getTipo(),
                cantidad,
                precioBase,
                descuentoAplicado,
                precioUnitarioFinal,
                totalCompra
        );
        this.historialCompras.add(registro);

        this.boletosVendidosAcumulados += cantidad;
        this.ingresosAcumulados = this.ingresosAcumulados.add(totalCompra).setScale(2, RoundingMode.HALF_UP);

        return new CompraResponse(
                registro.getTipo(),
                registro.getCantidad(),
                registro.getPrecioBase(),
                registro.getDescuentoAplicado(),
                registro.getPrecioUnitarioFinal(),
                registro.getTotal(),
                this.ingresosAcumulados
        );
    }

    private Boleto obtenerBoletoValido(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new SolicitudInvalidaException("El tipo de boleto es obligatorio");
        }
        Boleto boleto = catalogoModalidades.get(tipo);
        if (boleto == null) {
            throw new TipoBoletoInvalidoException("La modalidad '" + tipo + "' no es valida. Use GENERAL, PASE_ANUAL, ALUMNO o PROFESOR");
        }
        return boleto;
    }

    public BigDecimal getIngresosAcumulados() {
        return ingresosAcumulados;
    }

    public int getBoletosVendidosAcumulados() {
        return boletosVendidosAcumulados;
    }

    public List<RegistroCompra> getHistorialCompras() {
        return List.copyOf(historialCompras);
    }
}
