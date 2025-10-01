package com.gsmh.entity_dto_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsmh.entity_dto_demo.dto.PersonaDTO;
import com.gsmh.entity_dto_demo.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    //constructor
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    
    @GetMapping("/test")
    public String Test(){
        //la intencion de este metodo es validar que el servicio este corriendo
        return "Prueba de servicio OK!";
    }

    //buscar
    @GetMapping("/getall")
    public List<PersonaDTO> getAllPersonas(){
        return this.personaService.getAllPersonas();
    }
    @GetMapping("/get/{id}")
    public PersonaDTO getPersonaById(@PathVariable("id") Long id) {
        return this.personaService.getPersonaById(id);
    }
    @GetMapping("/getbynombre/{nombre}")
    public ResponseEntity<?> getByNombre(@PathVariable("nombre") String nombre) {
        PersonaDTO persona = this.personaService.getByNombre(nombre);
        return ResponseEntity.ok(persona);
    }
    @GetMapping("/getbyapellido/{apellido}")
    public ResponseEntity<?> getByApellido(@PathVariable("apellido") String nombre) {
        PersonaDTO persona = this.personaService.getByApellido(nombre);
        return ResponseEntity.ok(persona);
    }

    //insertar
    @PostMapping("/create")
    public ResponseEntity <?> createPersonaDTO(@RequestBody PersonaDTO personaDTO){
        //try{
            PersonaDTO respuesta = this.personaService.createPersona(personaDTO);
            return ResponseEntity.ok(respuesta);
        //} catch(Exception e){
            //System.out.println(e);
            //return new ResponseEntity<>("Exception en createPersonaDTO: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            //return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        //}
    }

    //actualizar
    @PutMapping("/update")
    public ResponseEntity <?> updatePersonaDTO(@RequestBody PersonaDTO personaDTO){
        //try{
            PersonaDTO respuesta = this.personaService.updatePersona(personaDTO);
            return ResponseEntity.ok(respuesta);
        //} catch(Exception e){
            //System.out.println(e);
            //return new ResponseEntity<>("Exception en updatePersonaDTO: " + e.getMessage() + "" + e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
            //return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        //}
    }

    //eliminar
    @PostMapping("/delete/{id}")
    public String deletePersona(@PathVariable("id") Long id){
        return this.personaService.deletePersona(id);
    }

}
