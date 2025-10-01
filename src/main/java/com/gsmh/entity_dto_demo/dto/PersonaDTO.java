package com.gsmh.entity_dto_demo.dto;

import java.util.List;

public class PersonaDTO {
    private long id;
    private String email;
    private String nombre;
    private String apellido;
    private String dpi;
    private String descripcion;
    private List<DireccionDTO> direcciones;
    private List<TelefonoDTO> telefonos;
    //getters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDpi() { return dpi; }
    public String getDescripcion() { return descripcion; }
    public List<DireccionDTO> getDirecciones() { return direcciones; }
    public List<TelefonoDTO> getTelefonos() { return telefonos; }
    //setters
    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setDpi(String dpi) { this.dpi = dpi; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setDirecciones(List<DireccionDTO> direcciones) { this.direcciones = direcciones; }
    public void setTelefonos(List<TelefonoDTO> telefonos) { this.telefonos = telefonos; }

    /*
    public String getInfo(){
        String s = "";
        s = "id = " + this.id;
        s += ", email = " + this.email;
        s += ", nombre = " + this.nombre;
        s += ", apellido = " + this.apellido;
        s += ", dpi = " + this.dpi;
        s += ";";
        return s;
    }
    */
    
}
