package com.gsmh.entity_dto_demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsmh.entity_dto_demo.dto.UsuarioDTO;
import com.gsmh.entity_dto_demo.exception.UsuarioNotFoundException;
import com.gsmh.entity_dto_demo.mapper.impl.UsuarioMapperServiceImpl;
import com.gsmh.entity_dto_demo.model.Usuario;
import com.gsmh.entity_dto_demo.repository.UsuarioRepository;
import com.gsmh.entity_dto_demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioMapperServiceImpl usuarioMapper;

    public AuthServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    public UsuarioDTO getUsuarioById(Long id){
        if (this.usuarioRepository.findById(id).isEmpty()){
            throw new UsuarioNotFoundException("No se encontro el usuario con id: " + id);
        }
        Usuario usuario = this.usuarioRepository.findById(id).get();
        return this.usuarioMapper.toDTO(usuario);
    }

    @Override
    public UsuarioDTO getByUsuario(String usuario){
        if (this.usuarioRepository.findByUsuario(usuario) == null){
            throw new UsuarioNotFoundException("No se encontro el usuario: " + usuario);
        }
        Usuario usuarioBusqueda = this.usuarioRepository.findByUsuario(usuario);
        return this.usuarioMapper.toDTO(usuarioBusqueda);
    }

    @Override
    public List<UsuarioDTO> getAllUsuarios(){
        return usuarioRepository.findAll().stream()
            .map(this.usuarioMapper::toDTO)
            .collect(Collectors.toList());
    }


}
