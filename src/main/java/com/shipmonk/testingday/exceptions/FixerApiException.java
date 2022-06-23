package com.shipmonk.testingday.exceptions;

public class FixerApiException extends RuntimeException {
    public FixerApiException(String errorMessage) {
        super(errorMessage);
    }
}

