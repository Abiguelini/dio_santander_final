package com.example.Dio_final.Controller;

import com.example.Dio_final.Model.Bibliotecario;
import com.example.Dio_final.Repositories.BibliotecarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecarios")
public class BibliotecarioController {

    @Autowired
    BibliotecarioRepository bibliotecarioRepository;

    @GetMapping
    public ResponseEntity<List<Bibliotecario>> getAllBibliotecarios() {
        List<Bibliotecario> bibliotecarios = bibliotecarioRepository.findAll();
        return new ResponseEntity<>(bibliotecarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bibliotecario> createBibliotecario(@RequestBody Bibliotecario bibliotecario) {
        Bibliotecario newBibliotecario = bibliotecarioRepository.save(bibliotecario);
        return new ResponseEntity<>(newBibliotecario, HttpStatus.CREATED);
    }
}