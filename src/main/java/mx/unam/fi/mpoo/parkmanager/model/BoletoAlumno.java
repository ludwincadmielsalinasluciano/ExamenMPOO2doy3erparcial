package mx.unam.fi.mpoo.parkmanager.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BoletoAlumno extends Boleto {

    private static final BigDecimal PRECIO_BASE = new BigDecimal("650.00").setScale(2, RoundingMode.HALF_UP);

    public BoletoAlumno() {
        super("ALUMNO");
    }

    @Override
    public BigDecimal obtenerPrecioBase() {
        return PRECIO_BASE;
    }
}
