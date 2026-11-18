package mx.unam.fi.mpoo.parkmanager.exception;

import mx.unam.fi.mpoo.parkmanager.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ParkManagerException.class)
    public ResponseEntity<ErrorResponse> manejarExcepcionDeNegocio(ParkManagerException ex) {
        ErrorResponse error = new ErrorResponse(ex.getCodigo(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class,
            MissingPathVariableException.class
    })
    public ResponseEntity<ErrorResponse> manejarSolicitudMalFormada(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                "SOLICITUD_INVALIDA",
                "Solicitud sin campos obligatorios o mal formada"
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
