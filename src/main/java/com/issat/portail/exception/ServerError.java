package com.issat.portail.exception;

public class ServerError extends  Exception {
    public ServerError() {
        super();
    }

    public ServerError(String message) {
        super(message);
    }
}
