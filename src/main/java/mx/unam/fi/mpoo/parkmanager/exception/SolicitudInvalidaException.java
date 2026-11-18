package mx.unam.fi.mpoo.parkmanager.exception;

public class SolicitudInvalidaException extends ParkManagerException {
    
    public SolicitudInvalidaException(String mensaje) {
        super("SOLICITUD_INVALIDA", mensaje);
    }
}
