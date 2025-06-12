package com.cefet.projeto_academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.projeto_academia.entities.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long>{
    
}
