package com.parking.exceptions;

public class ResourcesNotFoundException extends RuntimeException {

    public ResourcesNotFoundException() {
        super();
    }

    public ResourcesNotFoundException(String message) {
        super(message);
    }
}
