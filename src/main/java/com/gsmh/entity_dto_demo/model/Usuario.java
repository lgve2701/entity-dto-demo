package com.gsmh.entity_dto_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usuario;
    private String contrasena;
    @Column(name="display_name")
    private String displayName;
    private String email;
    private String rol;

    //getters
    public Long getId() { return id; }
    public String getUsuario() {return usuario;}
    public String getContrasena() {return contrasena;}
    public String getDisplayName() {return displayName;}
    public String getEmail() {return email;}
    public String getRol() {return rol;}
    //setters
    public void setId(Long id) { this.id = id; }
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public void setContrasena(String contrasena) {this.contrasena = contrasena;}
    public void setDisplayName(String displayName) {this.displayName = displayName;}
    public void setEmail(String email) {this.email = email;}
    public void setRol(String rol) {this.rol = rol;}

}
