package com.company.exceptions;

public class NotImplementedException extends RuntimeException {

    public NotImplementedException() {
        super();
    }

    public NotImplementedException(String message) {
        super(message);
    }

    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotImplementedException(Throwable cause) {
        super(cause);
    }

    protected NotImplementedException(String message, Throwable cause, boolean enableSuppression, boolean stacktrace) {
        super(message, cause, enableSuppression, stacktrace);
    }

}

