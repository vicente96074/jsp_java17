package com.kojstarinnovations.conjava17.domain.exception;

public class SQLExceptionCustomized extends RuntimeException{
    public SQLExceptionCustomized(String message){
        super(message);
    }

    public SQLExceptionCustomized(String message, Throwable cause){
        super(message, cause);
    }
}
