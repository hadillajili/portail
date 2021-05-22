package com.issat.portail.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BadRequest extends Exception {
    public BadRequest() {
        super();
    }

    public BadRequest(String message) {
        super(message);
    }
}
