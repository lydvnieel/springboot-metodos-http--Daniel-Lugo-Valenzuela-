package com.utez.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.utez.dto.RegisterRequest;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    // Método GET: consulta información
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(@RequestParam(defaultValue = "Estudiante") String name) {
        return ResponseEntity.ok("Hola, " + name + "! Bienvenido a Spring Boot.");
    }

    // Método POST: recibe un DTO en el cuerpo de la solicitud
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {
        if (request.getUsername() == null || request.getUsername().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'username' es obligatorio");
        }
        return ResponseEntity.status(201)
                .body("Usuario " + request.getUsername() + " registrado correctamente.");
    }
}
