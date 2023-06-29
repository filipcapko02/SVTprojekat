package com.example.demo.exceptions;

public class SpringDemoException extends RuntimeException {
    public SpringDemoException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringDemoException(String exMessage) {
        super(exMessage);
    }
}
