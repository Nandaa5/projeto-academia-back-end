package com.cefet.projeto_academia.repositories;

import com.cefet.projeto_academia.entities.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByLogin(String login);

    List<Usuario> findByPessoaId(Long pessoaId);
}

