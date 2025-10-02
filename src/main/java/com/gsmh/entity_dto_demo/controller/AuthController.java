package com.gsmh.entity_dto_demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsmh.entity_dto_demo.dto.UsuarioDTO;
import com.gsmh.entity_dto_demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/test")
    public String Test(){
        //la intencion de este metodo es validar que el servicio este corriendo
        return "Prueba de servicio OK!";
    }

    @GetMapping("/getall")
    public ResponseEntity <?> getAllUsers() {
        try{
            List<UsuarioDTO> lista = authService.getAllUsuarios();
            return ResponseEntity.ok(lista);
        } catch (Exception e){
            System.out.println("Error: " + e);
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    
}
