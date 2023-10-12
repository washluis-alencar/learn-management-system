package br.com.challenge.exception;

/**
 * Exception to deal with service layer
 * @author Alencar, Washington
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}
