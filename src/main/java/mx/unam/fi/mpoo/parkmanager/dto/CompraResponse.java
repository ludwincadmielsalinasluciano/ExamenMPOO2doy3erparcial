package mx.unam.fi.mpoo.parkmanager.dto;

import java.math.BigDecimal;

public class CompraResponse {

    private String tipo;
    private int cantidad;
    private BigDecimal precioBase;
    private int descuentoAplicado;
    private BigDecimal precioUnitarioFinal;
    private BigDecimal total;
    private BigDecimal ingresosAcumulados;

    public CompraResponse(String tipo, int cantidad, BigDecimal precioBase, int descuentoAplicado,
                          BigDecimal precioUnitarioFinal, BigDecimal total, BigDecimal ingresosAcumulados) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precioBase = precioBase;
        this.descuentoAplicado = descuentoAplicado;
        this.precioUnitarioFinal = precioUnitarioFinal;
        this.total = total;
        this.ingresosAcumulados = ingresosAcumulados;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public int getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public BigDecimal getPrecioUnitarioFinal() {
        return precioUnitarioFinal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getIngresosAcumulados() {
        return ingresosAcumulados;
    }
}
