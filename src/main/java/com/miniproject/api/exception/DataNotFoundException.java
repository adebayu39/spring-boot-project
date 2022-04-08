package com.miniproject.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {
    public static final String NOT_FOUND_MESSAGE = "Resource %s with ID %s not found";

    public DataNotFoundException(String message) {
        super(message);
    }
}
