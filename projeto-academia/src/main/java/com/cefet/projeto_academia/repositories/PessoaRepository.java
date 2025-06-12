package com.cefet.projeto_academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.projeto_academia.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
