package com.gsmh.entity_dto_demo.mapper;

import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;

import com.gsmh.entity_dto_demo.dto.UsuarioDTO;
import com.gsmh.entity_dto_demo.model.Usuario;

@Mapper
public interface UsuarioMapper {
    //auto-instancia
    //UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);

    //metodos de mapeo
    UsuarioDTO toDTO(Usuario usuario);
    Usuario toEntity(UsuarioDTO usuarioDTO);    
}
