package com.miniproject.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class DataCreated extends RuntimeException {
    public static final String CREATED_MESSAGE = "Transaction with purchase id %s created";

    public DataCreated(String message) {
        super(message);
    }
}
