package com.gsmh.entity_dto_demo.mapper;

import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;

import com.gsmh.entity_dto_demo.dto.PersonaDTO;
import com.gsmh.entity_dto_demo.model.Persona;
// import com.gsmh.entity_dto_demo.dto.DireccionDTO;
// import com.gsmh.entity_dto_demo.model.Direccion;
// import com.gsmh.entity_dto_demo.dto.TelefonoDTO;
// import com.gsmh.entity_dto_demo.model.Telefono;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PersonaMapper {
    //auto-instancia
    //PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);

    PersonaDTO toDTO(Persona entity);
    // DireccionDTO toDTO(Direccion entity);
    // TelefonoDTO toDTO(Telefono entity);

    @Mappings({
        @Mapping(target = "direcciones", ignore = true),
        @Mapping(target = "telefonos", ignore = true)
    })
    Persona toEntity(PersonaDTO dto);
    // Direccion toEntity(DireccionDTO dto, Persona persona);
    // Telefono toEntity(TelefonoDTO dto, Persona persona);
    
    @Mappings({
        @Mapping(target = "direcciones", ignore = true),
        @Mapping(target = "telefonos", ignore = true)
    })
    Persona toEntityUpdate(PersonaDTO dto);

}
