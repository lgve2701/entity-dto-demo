package com.gsmh.entity_dto_demo.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gsmh.entity_dto_demo.dto.DireccionDTO;
import com.gsmh.entity_dto_demo.dto.PersonaDTO;
import com.gsmh.entity_dto_demo.dto.TelefonoDTO;
import com.gsmh.entity_dto_demo.model.Direccion;
import com.gsmh.entity_dto_demo.model.Persona;
import com.gsmh.entity_dto_demo.model.Telefono;

import com.gsmh.entity_dto_demo.mapper.PersonaMapper;

@Service
public class PersonaMapperServiceImpl implements PersonaMapper {

    // Entity a DTO
    @Override
    public PersonaDTO toDTO(Persona entity) {
        if (entity == null) return null;
        
        PersonaDTO dto = new PersonaDTO();

        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setDpi(entity.getDpi());
      
        if (entity.getDirecciones() != null) {
            dto.setDirecciones(
                entity.getDirecciones().stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList())
            );
        }
        
        if (entity.getTelefonos() != null) {
            dto.setTelefonos(
                entity.getTelefonos().stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList())
            );
        }
        
        return dto;
    }
    
    private DireccionDTO toDTO(Direccion entity) {
        if (entity == null) return null;
        
        DireccionDTO dto = new DireccionDTO();
        dto.setId(entity.getId());
        dto.setDireccionCompleta(entity.getDireccionCompleta());
        dto.setCodigoPostal(entity.getCodigoPostal());
        
        return dto;
    }
    
    private TelefonoDTO toDTO(Telefono entity) {
        if (entity == null) return null;
        
        TelefonoDTO dto = new TelefonoDTO();
        dto.setId(entity.getId());
        dto.setNumero(entity.getNumero());
        dto.setTipo(entity.getTipo());
        
        return dto;
    }

    // DTO a Entity
    @Override
    public Persona toEntity(PersonaDTO dto) {
        if (dto == null) return null;
        
        Persona persona = new Persona();

        //persona.setId(dto.getId());
        persona.setEmail(dto.getEmail());
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setDpi(dto.getDpi());
        
        // Convertir direcciones
        if (dto.getDirecciones() != null) {
            List<Direccion> direcciones = dto.getDirecciones().stream()
                .map(dirDTO -> toEntity(dirDTO, persona))
                .collect(Collectors.toList());
            persona.setDirecciones(direcciones);
        }
        
        // Convertir teléfonos
        if (dto.getTelefonos() != null) {
            List<Telefono> telefonos = dto.getTelefonos().stream()
                .map(telDTO -> toEntity(telDTO, persona))
                .collect(Collectors.toList());
            persona.setTelefonos(telefonos);
        }
        
        return persona;
    }
    
    private Direccion toEntity(DireccionDTO dto, Persona persona) {
        if (dto == null) return null;
        
        Direccion direccion = new Direccion();
        //direccion.setId(dto.getId());
        direccion.setDireccionCompleta(dto.getDireccionCompleta());
        direccion.setCodigoPostal(dto.getCodigoPostal());
        //direccion.setId(persona.getId());
        direccion.setPersona(persona);
        
        return direccion;
    }
    
    private Telefono toEntity(TelefonoDTO dto, Persona persona) {
        if (dto == null) return null;
        
        Telefono telefono = new Telefono();
        //telefono.setId(dto.getId());
        telefono.setNumero(dto.getNumero());
        telefono.setTipo(dto.getTipo());
        //telefono.setId(persona.getId());
        telefono.setPersona(persona);

        return telefono;
    }


    @Override
    public Persona toEntityUpdate(PersonaDTO dto) {
        if (dto == null) return null;
        
        Persona persona = new Persona();

        persona.setId(dto.getId());
        persona.setEmail(dto.getEmail());
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setDpi(dto.getDpi());
        
        // Convertir direcciones
        if (dto.getDirecciones() != null) {
            List<Direccion> direcciones = dto.getDirecciones().stream()
                .map(dirDTO -> toEntityUpdate(dirDTO, persona))
                .collect(Collectors.toList());
            persona.setDirecciones(direcciones);
        }
        
        // Convertir teléfonos
        if (dto.getTelefonos() != null) {
            List<Telefono> telefonos = dto.getTelefonos().stream()
                .map(telDTO -> toEntityUpdate(telDTO, persona))
                .collect(Collectors.toList());
            persona.setTelefonos(telefonos);
        }
        
        return persona;
    }
    private Direccion toEntityUpdate(DireccionDTO dto, Persona persona) {
        if (dto == null) return null;
        
        Direccion direccion = new Direccion();
        direccion.setId(dto.getId());
        direccion.setDireccionCompleta(dto.getDireccionCompleta());
        direccion.setCodigoPostal(dto.getCodigoPostal());
        direccion.setPersona(persona);
        
        return direccion;
    }
    
    private Telefono toEntityUpdate(TelefonoDTO dto, Persona persona) {
        if (dto == null) return null;
        
        Telefono telefono = new Telefono();
        telefono.setId(dto.getId());
        telefono.setNumero(dto.getNumero());
        telefono.setTipo(dto.getTipo());
        telefono.setPersona(persona);

        return telefono;
    }

    
}
