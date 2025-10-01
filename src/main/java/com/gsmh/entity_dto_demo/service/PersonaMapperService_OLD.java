package com.gsmh.entity_dto_demo.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

//import com.fasterxml.jackson.databind.ObjectMapper;

import com.gsmh.entity_dto_demo.dto.DireccionDTO;
import com.gsmh.entity_dto_demo.dto.PersonaDTO;
import com.gsmh.entity_dto_demo.dto.TelefonoDTO;
import com.gsmh.entity_dto_demo.model.Direccion;
import com.gsmh.entity_dto_demo.model.Persona;
import com.gsmh.entity_dto_demo.model.Telefono;
import com.gsmh.entity_dto_demo.repository.PersonaRepository;
// import com.gsmh.entity_dto_demo.repository.DireccionRepository;
// import com.gsmh.entity_dto_demo.repository.TelefonoRepository;

@Service
public class PersonaMapperService_OLD{
    PersonaRepository personaRepository;
    // DireccionRepository direccionRepository;
    // TelefonoRepository telefonoRepository;

    public PersonaMapperService_OLD(PersonaRepository personaRepository){ //, DireccionRepository direccionRepository, TelefonoRepository telefonoRepository) {
        this.personaRepository = personaRepository;
        // this.direccionRepository = direccionRepository;
        // this.telefonoRepository = telefonoRepository;
    }

    public PersonaDTO getPersonaById(Long id){
        //return this.personaRepository.findById(id).get();
        System.out.println("- persona -");
        if (this.personaRepository.findById(id).isEmpty()){
            throw new RuntimeException("No se encontro la persona con id: " + id);
        }
        Persona persona = this.personaRepository.findById(id).get();
        //ObjectMapper mapper = new ObjectMapper();
        //String jsonString = mapper.writeValueAsString(persona);
        //System.out.println(jsonString);
        //System.out.println(persona.getInfo());
        return toDTO(persona);
    }

    public List<PersonaDTO> getAllPersonas() {
        return this.personaRepository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public Persona savePersona(Persona persona){
        return this.personaRepository.save(persona);
    }

    // ----- Mapper ----- //

    // DTO a Entity
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
    
    // Entity a DTO
    public PersonaDTO toDTO(Persona entity) {
        if (entity == null) return null;
        
        PersonaDTO dto = new PersonaDTO();

        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setDpi(entity.getDpi());

        /*
        List<Long> list = new ArrayList<>();
        list.add(entity.getId());
        List<Direccion> direccion = null;
        List<Telefono> telefono = null;
        direccion = direccionRepository.findAllById(list);
        telefono = telefonoRepository.findAllById(list);
        System.out.println("- direcciones -");
        direccion.forEach(dir -> {
            System.err.println(
                "id: " + dir.getId() + ", " +
                "direccionCompleta: " + dir.getDireccionCompleta() + ", " + 
                "codigoPostal: " + dir.getCodigoPostal() + " - ");
        });
        System.out.println("- telefonos -");
        telefono.forEach(tel -> {
            System.err.println(
                "id: " + tel.getId() + ", " +
                "numero: " + tel.getNumero() + ", " + 
                "tipo: " + tel.getTipo() + " - ");
        });
        */
       
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

}
