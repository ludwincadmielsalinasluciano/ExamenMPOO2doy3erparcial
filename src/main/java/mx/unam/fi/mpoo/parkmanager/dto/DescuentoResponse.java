package mx.unam.fi.mpoo.parkmanager.dto;

public class DescuentoResponse {

    private String tipo;
    private int porcentaje;
    private String mensaje;

    public DescuentoResponse(String tipo, int porcentaje, String mensaje) {
        this.tipo = tipo;
        this.porcentaje = porcentaje;
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
