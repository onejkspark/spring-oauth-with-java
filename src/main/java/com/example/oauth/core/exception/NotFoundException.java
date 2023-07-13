package com.example.oauth.core.exception;

public final class NotFoundException extends RuntimeException {
    private static final String message = "Data Not Found";

    public NotFoundException() {
        super(message);
    }
}
