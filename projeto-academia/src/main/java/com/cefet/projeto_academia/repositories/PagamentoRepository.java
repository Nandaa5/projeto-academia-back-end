package com.cefet.projeto_academia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.projeto_academia.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository <Pagamento, Long> {
    List<Pagamento> findByMatriculaId(Long matriculaId);
}


