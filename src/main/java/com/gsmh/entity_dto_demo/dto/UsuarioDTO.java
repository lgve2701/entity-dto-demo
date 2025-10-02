package com.gsmh.entity_dto_demo.dto;

public class UsuarioDTO {
    private long id;
    private String usuario;
    private String contrasena;
    private String displayName;
    private String email;
    private String rol;

    //getters
    public Long getId() {return id;}
    public String getUsuario() {return usuario;}
    public String getContrasena() {return contrasena;}
    public String getDisplayName() {return displayName;}
    public String getEmail() {return email;}
    public String getRol() {return rol;}
    //setters
    public void setId(Long id) {this.id = id;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public void setContrasena(String contrasena) {this.contrasena = contrasena;}
    public void setDisplayName(String displayName) {this.displayName = displayName;}
    public void setEmail(String email) {this.email = email;}
    public void setRol(String rol) {this.rol = rol;}    
}
