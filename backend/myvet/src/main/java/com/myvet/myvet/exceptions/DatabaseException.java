package com.myvet.myvet.exceptions;

public class DatabaseException extends RuntimeException{
    
    public DatabaseException(String message){
        super(message);
    }
}
