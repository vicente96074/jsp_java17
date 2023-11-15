package com.kojstarinnovations.conjava17.domain.exception;

/**
 * Exception for duplicated objects
 *
 * @author Augusto Vicente
 */
public class DuplicatedException extends RuntimeException{
    public DuplicatedException(String message) {
        super(message);
    }
}
