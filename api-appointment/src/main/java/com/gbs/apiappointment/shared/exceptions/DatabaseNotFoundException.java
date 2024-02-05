package com.gbs.apiappointment.shared.exceptions;

public class DatabaseNotFoundException extends RuntimeException{
    public DatabaseNotFoundException(String message) {
        super(message);
    }
}
