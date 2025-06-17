package com.cefet.projeto_academia.services;

import com.cefet.projeto_academia.dto.UsuarioDTO;
import com.cefet.projeto_academia.entities.Pessoa;
import com.cefet.projeto_academia.entities.Usuario;
import com.cefet.projeto_academia.repositories.PessoaRepository;
import com.cefet.projeto_academia.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return new UsuarioDTO(usuario);
    }
//garante que o usuario nao seja alterado

    public UsuarioDTO insert(UsuarioDTO dto) {
        if (usuarioRepository.existsByLogin(dto.getLogin())) {
            throw new IllegalArgumentException("Login já existente.");
        }

        Usuario usuario = new Usuario();
        usuario.setLogin(dto.getLogin());
        usuario.setSenha(gerarSenhaAleatoria());
        usuario.setTipo(dto.getTipo());

        Pessoa pessoa = pessoaRepository.findById(dto.getIdPessoa())
            .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada."));
        usuario.setPessoa(pessoa);

        Usuario salvo = usuarioRepository.save(usuario);
        return new UsuarioDTO(salvo);
    }
//remover por id 
    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado.");
        }
        usuarioRepository.deleteById(id);
    }

    private String gerarSenhaAleatoria() {
        return String.valueOf(new Random().nextInt(999999));
    }
}
