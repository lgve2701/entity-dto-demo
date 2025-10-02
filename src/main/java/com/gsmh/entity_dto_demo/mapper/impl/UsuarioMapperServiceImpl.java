package com.gsmh.entity_dto_demo.mapper.impl;

import org.springframework.stereotype.Service;

import com.gsmh.entity_dto_demo.dto.UsuarioDTO;
import com.gsmh.entity_dto_demo.model.Usuario;

import com.gsmh.entity_dto_demo.mapper.UsuarioMapper;;

@Service
public class UsuarioMapperServiceImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDTO(Usuario entity) {
        if (entity == null) return null;
        
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setUsuario(entity.getUsuario());
        dto.setContrasena(entity.getContrasena());
        dto.setDisplayName(entity.getDisplayName());
        dto.setEmail(entity.getEmail());
        dto.setRol(entity.getRol());
        
        return dto;
    }

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;
        
        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setUsuario(dto.getUsuario());
        entity.setContrasena(dto.getContrasena());
        entity.setDisplayName(dto.getDisplayName());
        entity.setEmail(dto.getEmail());
        entity.setRol(dto.getRol());
        
        return entity;
    }
    
}
