package com.kojstarinnovations.jps17.exception;

public class SQLExceptionCustomized extends RuntimeException{
    public SQLExceptionCustomized(String message){
        super(message);
    }

    public SQLExceptionCustomized(String message, Throwable cause){
        super(message, cause);
    }
}
