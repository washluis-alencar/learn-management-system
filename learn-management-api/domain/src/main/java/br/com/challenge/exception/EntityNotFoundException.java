package br.com.challenge.exception;

/**
 * Exception to be thrown when an entity is not found.
 * @author Alencar, Washington
 */
public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException() {}
}
