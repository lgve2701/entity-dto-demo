package com.gsmh.entity_dto_demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String nombre;
    private String apellido;
    private String dpi;
    private String descripcion;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Direccion> direcciones;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefono> telefonos;

    //getters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDpi() { return dpi; }
    public String getDescripcion() { return descripcion; }
    public List<Direccion> getDirecciones() { return direcciones; }
    public List<Telefono> getTelefonos() { return telefonos; }
    //setters
    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setDpi(String dpi) { this.dpi = dpi; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setDirecciones(List<Direccion> direcciones) { this.direcciones = direcciones; }
    public void setTelefonos(List<Telefono> telefonos) { this.telefonos = telefonos; }
    
    //constructores
    public Persona(){
        this.id = 0;
        this.email = "";
        this.nombre = "";
        this.apellido = "";
        this.dpi = "";
        this.direcciones = null;
        this.telefonos = null;
    }
    public Persona(long id, String email, String nombre, String apellido, String dpi, List<Direccion> direcciones, List<Telefono> telefonos) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dpi = dpi;
        this.direcciones = direcciones;
        this.telefonos = telefonos;
    }

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
