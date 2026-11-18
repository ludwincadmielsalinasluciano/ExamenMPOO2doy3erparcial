package mx.unam.fi.mpoo.parkmanager.dto;

public class ErrorResponse {

    private String codigo;
    private String mensaje;

    public ErrorResponse(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
