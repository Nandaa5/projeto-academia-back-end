package com.cefet.projeto_academia.repositories;

import com.cefet.projeto_academia.entities.Usuario;
import java.util.List;
import java.util.Optional; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
  
    Optional<Usuario> findByLogin(String login);

    boolean existsByLogin(String login);

    List<Usuario> findByPessoaId(Long pessoaId);
}
