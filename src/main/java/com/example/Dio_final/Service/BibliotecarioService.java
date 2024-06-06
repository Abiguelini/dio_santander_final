package com.example.Dio_final.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Dio_final.Model.Bibliotecario;

import com.example.Dio_final.Repositories.BibliotecarioRepository;


@Service
public class BibliotecarioService {

    @Autowired
    BibliotecarioRepository bibliotecarioRepository;

    @Autowired
    public BibliotecarioService(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    public List<Bibliotecario> findAllBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

     public Optional<Bibliotecario> getById(Long id) {
        return bibliotecarioRepository.findById(id);
    }
}
