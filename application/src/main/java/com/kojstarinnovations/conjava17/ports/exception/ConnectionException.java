package com.kojstarinnovations.conjava17.ports.exception;

/**
 * Exception to handle connection errors
 *
 * @author Augusto Vicente
 */
public class ConnectionException extends RuntimeException{
    public ConnectionException(String message) {
        super(message);
    }
}
