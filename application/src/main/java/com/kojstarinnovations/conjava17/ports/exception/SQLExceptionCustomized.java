package com.kojstarinnovations.conjava17.ports.exception;

public class SQLExceptionCustomized extends RuntimeException{
    public SQLExceptionCustomized(String message){
        super(message);
    }

    public SQLExceptionCustomized(String message, Throwable cause){
        super(message, cause);
    }
}
