package com.gbs.apiuser.shared.exceptions;

public class DatabaseNotFoundException extends RuntimeException{
    public DatabaseNotFoundException(String message) {
        super(message);
    }
}
