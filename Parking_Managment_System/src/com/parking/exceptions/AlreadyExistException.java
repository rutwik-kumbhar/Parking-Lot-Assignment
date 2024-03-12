package com.parking.exceptions;

public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException() {
        super();
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
