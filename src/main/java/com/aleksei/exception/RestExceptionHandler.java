package com.aleksei.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.persistence.EntityNotFoundException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected Error handleEntityNotFound(EntityNotFoundException ex) {
        Error error = new Error(ex.getMessage(), ex);
        return error;
    }

    @ExceptionHandler(PhoneIsAlreadyBooked.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    protected Error handlePhoneIsAlreadyBooked(PhoneIsAlreadyBooked ex) {
        Error error = new Error(ex.getMessage(), ex);
        return error;
    }
}
