package com.gsmh.entity_dto_demo.dto;

public class DireccionDTO {
    private long id;
    private String direccionCompleta;
    private String codigoPostal;
    //getters
    public Long getId() { return id; }
    public String getDireccionCompleta() { return direccionCompleta; }
    public String getCodigoPostal() { return codigoPostal; }
    //setters
    public void setId(Long id) { this.id = id; }
    public void setDireccionCompleta(String direccionCompleta) { this.direccionCompleta = direccionCompleta; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
}
