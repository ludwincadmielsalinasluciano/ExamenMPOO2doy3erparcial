package mx.unam.fi.mpoo.parkmanager.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BoletoProfesor extends Boleto {

    private static final BigDecimal PRECIO_BASE = new BigDecimal("700.00").setScale(2, RoundingMode.HALF_UP);

    public BoletoProfesor() {
        super("PROFESOR");
    }

    @Override
    public BigDecimal obtenerPrecioBase() {
        return PRECIO_BASE;
    }
}
