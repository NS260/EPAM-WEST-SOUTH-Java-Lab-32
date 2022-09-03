package com.epam.spring.project.service.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
