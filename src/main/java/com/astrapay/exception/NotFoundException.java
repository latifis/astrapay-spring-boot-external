package com.astrapay.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("Data not found: " + id);
    }
}