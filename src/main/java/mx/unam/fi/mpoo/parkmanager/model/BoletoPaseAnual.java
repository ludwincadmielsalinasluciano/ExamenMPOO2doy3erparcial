package mx.unam.fi.mpoo.parkmanager.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BoletoPaseAnual extends Boleto {

    private static final BigDecimal PRECIO_BASE = new BigDecimal("2400.00").setScale(2, RoundingMode.HALF_UP);

    public BoletoPaseAnual() {
        super("PASE_ANUAL");
    }

    @Override
    public BigDecimal obtenerPrecioBase() {
        return PRECIO_BASE;
    }
}
