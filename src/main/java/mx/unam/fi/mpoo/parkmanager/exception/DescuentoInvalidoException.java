package mx.unam.fi.mpoo.parkmanager.exception;

public class DescuentoInvalidoException extends ParkManagerException {
    
    public DescuentoInvalidoException(String mensaje) {
        super("DESCUENTO_INVALIDO", mensaje);
    }
}
