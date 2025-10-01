package com.gsmh.entity_dto_demo.model;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefono")
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @Column(name="id_persona")
    // private long idPersona;

    private String numero;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    //getters
    public Long getId() { return id; }
    //public Long getIdPersona() { return idPersona; }
    public String getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public Persona getPersona() { return persona; }
    //setters
    public void setId(Long id) { this.id = id; }
    //public void setIdPersona(Long idPersona) { this.idPersona = idPersona; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setNumero(String numero) { this.numero = numero; }
    public void setPersona(Persona persona) { this.persona = persona; }

    //constructores
    public Telefono(){
        this.id = 0;
        //this.idPersona = 0;
        this.numero = "";
        this.tipo = "";
    }
    public Telefono(Long id, Long idPersona, String numero, String tipo) {
        this.id = id;
        //this.idPersona = idPersona;
        this.numero = numero;
        this.tipo = tipo;
    }

    /*
    public String getInfo(){
        String s = "";
        s = "id = " + this.id;
        //s += ", idPersona = " + this.idPersona;
        s += ", numero = " + this.numero;
        s += ", tipo = " + this.tipo;
        s += ";";
        return s;
    }
    */

}
