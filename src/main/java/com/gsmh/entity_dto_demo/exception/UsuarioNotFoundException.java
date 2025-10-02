package com.gsmh.entity_dto_demo.exception;

public class UsuarioNotFoundException extends RuntimeException {
    
    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

//2.1 exception dedicada a casos de busqueda y no se encuentra el registro
