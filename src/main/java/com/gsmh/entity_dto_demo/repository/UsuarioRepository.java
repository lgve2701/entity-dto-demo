package com.gsmh.entity_dto_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsmh.entity_dto_demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsuario(String usuario);

}
