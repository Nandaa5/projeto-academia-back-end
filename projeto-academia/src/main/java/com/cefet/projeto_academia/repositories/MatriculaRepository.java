package com.cefet.projeto_academia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.projeto_academia.entities.Matricula;

public interface MatriculaRepository extends JpaRepository <Matricula, Long>{

    List<Matricula> findByPlanoId(Long planoId);
    List<Matricula> findByPessoaId(Long pessoaId);
}



