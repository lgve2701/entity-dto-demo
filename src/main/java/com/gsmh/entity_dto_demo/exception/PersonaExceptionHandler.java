package com.gsmh.entity_dto_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonaExceptionHandler {

    @ExceptionHandler(value = {PersonaNotFoundException.class})
    public ResponseEntity<Object> handlePersonaNotFoundException(PersonaNotFoundException notFoundEx){
        PersonaException ex = new PersonaException(
            notFoundEx.getMessage(), 
            notFoundEx.getCause(), 
            HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {PersonaDataIntegrityException.class})
    public ResponseEntity<Object> handlePersonaDataIntegrityException(PersonaDataIntegrityException dataIntegrityEx){
        PersonaException ex = new PersonaException(
            dataIntegrityEx.getMessage(), 
            dataIntegrityEx.getCause(), 
            HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
