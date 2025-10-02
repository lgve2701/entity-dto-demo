package com.gsmh.entity_dto_demo.service;

import java.util.List;

import com.gsmh.entity_dto_demo.dto.UsuarioDTO;

public interface AuthService {
    UsuarioDTO getUsuarioById(Long id);
    UsuarioDTO getByUsuario(String usuario);
    List<UsuarioDTO> getAllUsuarios();
    /*
    UsuarioDTO createUsuario(UsuarioDTO usuarioDTO); --> un usuario debe ser registrado
    UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO); --> solo actualizar password
    String deleteUsuario(Long id); --> usuario se da de baja pero no se elimina
    */
}
