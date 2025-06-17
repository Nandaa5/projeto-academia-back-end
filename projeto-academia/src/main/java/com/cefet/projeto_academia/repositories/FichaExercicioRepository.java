package com.cefet.projeto_academia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.projeto_academia.entities.FichaExercicio;

public interface FichaExercicioRepository extends JpaRepository <FichaExercicio, Long> {
    List<FichaExercicio> findByExercicioId(Long exercicioId);
    List<FichaExercicio> findByFichaId(Long fichaId);
}


