package mx.unam.fi.mpoo.parkmanager.exception;

public class TipoBoletoInvalidoException extends ParkManagerException {
    
    public TipoBoletoInvalidoException(String mensaje) {
        super("TIPO_BOLETO_INVALIDO", mensaje);
    }
}
