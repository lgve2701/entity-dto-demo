package com.gsmh.entity_dto_demo.service;

import java.util.List;

import com.gsmh.entity_dto_demo.dto.PersonaDTO;

public interface PersonaService {
    PersonaDTO getPersonaById(Long id);
    PersonaDTO getByNombre(String nombre);
    PersonaDTO getByApellido(String apellido);
    List<PersonaDTO> getAllPersonas();
    PersonaDTO createPersona(PersonaDTO persona);
    PersonaDTO updatePersona(PersonaDTO persona);
    String deletePersona(Long id);
}
