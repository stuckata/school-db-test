package com.stoyankirkov.schooldbtest.exception;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
