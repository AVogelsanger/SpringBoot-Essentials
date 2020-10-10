package br.com.devdojo.handler;

import br.com.devdojo.error.ResourceNotFoundException;
import br.com.devdojo.error.ResourcesNotFoundDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * @author vogue
 */
@ControllerAdvice
public class RestExceptionHandler {
    //@ExceptionHandler(ResourceNotFoundException.class);
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rfnException){
        ResourcesNotFoundDetails rfnDatails = ResourcesNotFoundDetails.Builder
                .newBuilder()
                .timeStamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .datail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();

        return new ResponseEntity<>(rfnDatails, HttpStatus.NOT_FOUND);
    }
}
