package com.gsmh.entity_dto_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsmh.entity_dto_demo.model.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    
}
