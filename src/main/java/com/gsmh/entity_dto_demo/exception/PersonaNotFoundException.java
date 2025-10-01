package com.gsmh.entity_dto_demo.exception;

public class PersonaNotFoundException extends RuntimeException {

    public PersonaNotFoundException(String message) {
        super(message);
    }

    public PersonaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

//2.1 exception dedicada a casos de busqueda y no se encuentra el registro
