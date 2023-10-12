package br.com.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Glabal handler exception to deeal with status and message error in all application
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorAPI> handleBaseServiceException(ServiceException exception, WebRequest request) {
        ErrorAPI errorAPI = ErrorAPI.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getLocalizedMessage())
                .timeStamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity(errorAPI, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorAPI> handleEntityNotFoundException(WebRequest request) {
        ErrorAPI errorAPI = ErrorAPI.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message("Resource not found")
                .timeStamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity(errorAPI, HttpStatus.NOT_FOUND);
    }

}
