package com.example.demo.exceptions;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String message) {
        super(message);
    }
}
