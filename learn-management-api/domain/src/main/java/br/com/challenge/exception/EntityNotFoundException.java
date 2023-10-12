package br.com.challenge.exception;

/**
 * Exception para recurso nao encontrado
 * @author Alencar, Washington
 */
public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException() {}
}
