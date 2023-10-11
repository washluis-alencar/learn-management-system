package br.com.challenge.exception;

/**
 * Classe base para exception de services
 * @author Alencar, Washington
 */
public class BaseServiceException extends Exception {
    public BaseServiceException(String message) {
        super(message);
    }
}
