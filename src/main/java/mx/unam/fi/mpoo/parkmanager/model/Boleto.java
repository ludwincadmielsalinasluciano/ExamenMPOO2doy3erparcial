package mx.unam.fi.mpoo.parkmanager.model;

import mx.unam.fi.mpoo.parkmanager.exception.CantidadInvalidaException;
import mx.unam.fi.mpoo.parkmanager.exception.DescuentoInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Boleto {

    private final String tipo;
    private int descuentoPorcentaje;

    protected Boleto(String tipo) {
        this.tipo = tipo;
        this.descuentoPorcentaje = 0;
    }

    public abstract BigDecimal obtenerPrecioBase();

    public void configurarDescuento(int nuevoPorcentaje) {
        if (nuevoPorcentaje < 0 || nuevoPorcentaje > 100) {
            throw new DescuentoInvalidoException("El porcentaje debe estar entre 0 y 100");
        }
        this.descuentoPorcentaje = nuevoPorcentaje;
    }

    public void desactivarDescuento() {
        this.descuentoPorcentaje = 0;
    }

    public BigDecimal calcularPrecioUnitarioFinal() {
        BigDecimal precioBase = obtenerPrecioBase().setScale(2, RoundingMode.HALF_UP);
        BigDecimal factorDescuento = BigDecimal.valueOf(100 - this.descuentoPorcentaje)
                .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
        return precioBase.multiply(factorDescuento).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularTotalCompra(int cantidad) {
        validarCantidad(cantidad);
        return calcularPrecioUnitarioFinal()
                .multiply(BigDecimal.valueOf(cantidad))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public void validarCantidad(int cantidad) {
        if (cantidad < 1 || cantidad > 10) {
            throw new CantidadInvalidaException("La cantidad de boletos debe ser un entero entre 1 y 10");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public int getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }
}
