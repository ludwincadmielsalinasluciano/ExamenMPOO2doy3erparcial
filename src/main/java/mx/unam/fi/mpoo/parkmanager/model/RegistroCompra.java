package mx.unam.fi.mpoo.parkmanager.model;

import java.math.BigDecimal;

public class RegistroCompra {

    private final String tipo;
    private final int cantidad;
    private final BigDecimal precioBase;
    private final int descuentoAplicado;
    private final BigDecimal precioUnitarioFinal;
    private final BigDecimal total;

    public RegistroCompra(String tipo, int cantidad, BigDecimal precioBase, int descuentoAplicado,
                          BigDecimal precioUnitarioFinal, BigDecimal total) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precioBase = precioBase;
        this.descuentoAplicado = descuentoAplicado;
        this.precioUnitarioFinal = precioUnitarioFinal;
        this.total = total;
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
}
