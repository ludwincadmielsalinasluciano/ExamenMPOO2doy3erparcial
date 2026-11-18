package mx.unam.fi.mpoo.parkmanager.exception;

public class CantidadInvalidaException extends ParkManagerException {
    
    public CantidadInvalidaException(String mensaje) {
        super("CANTIDAD_INVALIDA", mensaje);
    }
}
