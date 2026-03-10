package com.astrapay.dto;

import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public class ErrorResponseDto {
    private final OffsetDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final Object details;

    public ErrorResponseDto(int status, String error, String message, Object details) {
        this.timestamp = OffsetDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.details = details;
    }
}