package com.gsmh.entity_dto_demo.exception;

public class PersonaDataIntegrityException extends RuntimeException {
    
    public PersonaDataIntegrityException(String message) {
        super(message);
    }

    public PersonaDataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

//2.2 exception dedicada a casos de integridad de datos (DataIntegrityViolationException)

/*
Error al intentar actualizar persona. could not execute statement [Column 'email' cannot be null]
Error al intentar crear persona: could not execute statement [Data truncation: Data too long for column 'nombre' at row 1]
*/

