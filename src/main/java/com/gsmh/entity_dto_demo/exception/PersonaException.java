package com.gsmh.entity_dto_demo.exception;

import org.springframework.http.HttpStatus;

public class PersonaException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public PersonaException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    
}

//1. exception generica para el manejo de errores de la entidad
