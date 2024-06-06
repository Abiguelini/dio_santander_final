package com.example.Dio_final.Repositories;

import com.example.Dio_final.Model.Bibliotecario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
    
}