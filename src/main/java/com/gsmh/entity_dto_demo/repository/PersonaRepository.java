package com.gsmh.entity_dto_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsmh.entity_dto_demo.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    Persona findByNombre(String nombre);
    Persona findByApellido(String apellido);

}
