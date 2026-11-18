package mx.unam.fi.mpoo.parkmanager.exception;

public abstract class ParkManagerException extends RuntimeException {
    
    private final String codigo;

    protected ParkManagerException(String codigo, String mensaje) {
        super(mensaje);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
