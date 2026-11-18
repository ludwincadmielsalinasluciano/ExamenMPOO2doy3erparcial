package mx.unam.fi.mpoo.parkmanager.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BoletoGeneral extends Boleto {

    private static final BigDecimal PRECIO_BASE = new BigDecimal("900.00").setScale(2, RoundingMode.HALF_UP);

    public BoletoGeneral() {
        super("GENERAL");
    }

    @Override
    public BigDecimal obtenerPrecioBase() {
        return PRECIO_BASE;
    }
}
