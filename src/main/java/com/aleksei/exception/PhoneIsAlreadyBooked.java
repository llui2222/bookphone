package com.aleksei.exception;

public class PhoneIsAlreadyBooked extends RuntimeException {

    public PhoneIsAlreadyBooked() {
    }

    public PhoneIsAlreadyBooked(String message) {
        super(message);
    }

    public PhoneIsAlreadyBooked(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneIsAlreadyBooked(Throwable cause) {
        super(cause);
    }

    public PhoneIsAlreadyBooked(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
