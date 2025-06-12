package com.cefet.projeto_academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.projeto_academia.entities.Exercicio;

public interface  ExercicioRepository  extends JpaRepository<Exercicio, Long> {
    
}
