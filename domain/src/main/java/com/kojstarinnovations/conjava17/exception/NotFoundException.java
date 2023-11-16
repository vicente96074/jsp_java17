package com.kojstarinnovations.conjava17.exception;

/**
 * Exception to be thrown when an entity is not found
 *
 * @author Augusto Vicente
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
