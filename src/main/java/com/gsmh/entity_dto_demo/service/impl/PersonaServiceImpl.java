package com.gsmh.entity_dto_demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gsmh.entity_dto_demo.dto.PersonaDTO;
import com.gsmh.entity_dto_demo.exception.PersonaDataIntegrityException;
import com.gsmh.entity_dto_demo.exception.PersonaNotFoundException;
import com.gsmh.entity_dto_demo.model.Persona;
import com.gsmh.entity_dto_demo.repository.PersonaRepository;
import com.gsmh.entity_dto_demo.mapper.impl.PersonaMapperServiceImpl;
import com.gsmh.entity_dto_demo.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
    PersonaRepository personaRepository;
    @Autowired
    PersonaMapperServiceImpl personaMapper;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    //buscar
    @Override
    public PersonaDTO getPersonaById(Long id) {
        if (this.personaRepository.findById(id).isEmpty()){
            throw new PersonaNotFoundException("No se encontro la persona con id: " + id);
        }
        Persona persona = this.personaRepository.findById(id).get();
        return personaMapper.toDTO(persona);
    }
    @Override
    public PersonaDTO getByNombre(String nombre) {
        if (this.personaRepository.findByNombre(nombre) == null){
            throw new PersonaNotFoundException("No se encontro la persona con nombre: " + nombre);
        }
        Persona persona = this.personaRepository.findByNombre(nombre);
        return personaMapper.toDTO(persona);
    }
    @Override
    public PersonaDTO getByApellido(String apellido){
        if (this.personaRepository.findByApellido(apellido) == null){
            throw new PersonaNotFoundException("No se encontro la persona con apellido: " + apellido);
        }
        Persona persona = this.personaRepository.findByApellido(apellido);
        return personaMapper.toDTO(persona);
    }
    @Override
    public List<PersonaDTO> getAllPersonas() {
        return this.personaRepository.findAll().stream()
            .map(this.personaMapper::toDTO)
            .collect(Collectors.toList());
    }

    //insertar
    @Override
    public PersonaDTO createPersona(PersonaDTO personaDTO) {
        try{
            //parametro entrante pasa a modelo
            Persona persona = personaMapper.toEntity(personaDTO);
            //guardar con repository
            Persona personaGuardada = personaRepository.save(persona);
            //convertir a dto para respuesta
            PersonaDTO respuestaDTO = personaMapper.toDTO(personaGuardada);
            //regreso a controller            
            return respuestaDTO;
        }catch(DataIntegrityViolationException e){
            throw new PersonaDataIntegrityException("Error al intentar crear persona: " + e.getMessage(), e.getCause());
        }
    }

    //actualizar
    @Override
    public PersonaDTO updatePersona(PersonaDTO personaDTO) {
        try{
            //parametro entrante pasa a modelo
            Persona persona = personaMapper.toEntityUpdate(personaDTO);
            //guardar con repository
            Persona personaGuardada = this.personaRepository.save(persona);
            //convertir a dto para respuesta
            PersonaDTO respuestaDTO = personaMapper.toDTO(personaGuardada);
            //regreso a controller            
            return respuestaDTO;
        }catch(DataIntegrityViolationException e){
            throw new PersonaDataIntegrityException("Error al intentar actualizar persona. " + e.getMessage(), e.getCause());
        }
    }

    //eliminar
    @Override
    public String deletePersona(Long id) {
        this.personaRepository.deleteById(id);
        return "Persona eliminada con exito";
    }

}
