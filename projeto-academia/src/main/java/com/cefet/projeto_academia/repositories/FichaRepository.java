package com.cefet.projeto_academia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.projeto_academia.entities.Ficha;

public interface FichaRepository  extends JpaRepository <Ficha, Long>{
    List<Ficha> findByPessoaId(Long pessoaId);
}


