package com.gsmh.entity_dto_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // @Column(name="id_persona")
    // private long idPersona;
    @Column(name="direccion_completa")
    private String direccionCompleta;
    @Column(name="codigo_postal")
    private String codigoPostal;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    //getters
    public Long getId() { return id; }
    //public Long getIdPersona() { return idPersona; }
    public String getDireccionCompleta() { return direccionCompleta; }
    public String getCodigoPostal() { return codigoPostal; }
    public Persona getPersona() { return persona; }
    //setters
    public void setId(Long id) { this.id = id; }
    //public void setIdPersona(Long idPersona) { this.idPersona = idPersona; }
    public void setDireccionCompleta(String direccionCompleta) { this.direccionCompleta = direccionCompleta; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public void setPersona(Persona persona) { this.persona = persona; }

    //constructores
    public Direccion(){
        this.id = 0;
        //this.idPersona = 0;
        this.direccionCompleta = "";
        this.codigoPostal = "";
    }
    public Direccion(long id, Long idPersona, String direccionCompleta, String codigoPostal) {
        this.id = id;
        //this.idPersona = idPersona;
        this.direccionCompleta = direccionCompleta;
        this.codigoPostal = codigoPostal;
    }

    /*
    public String getInfo(){
        String s = "";
        s = "id = " + this.id;
        //s += ", idPersona = " + this.idPersona;
        s += ", direccionCompleta = " + this.direccionCompleta;
        s += ", codigoPostal = " + this.codigoPostal;
        s += ";";
        return s;
    }
    */

}
