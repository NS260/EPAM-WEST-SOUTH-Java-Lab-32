package com.epam.spring.project.service.exceptions;

public class RowNotFoundException extends RuntimeException {

    public RowNotFoundException(String message) {
        super(message);
    }
}
