package com.cefet.projeto_academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto_academia.dto.PessoaDTO;
import com.cefet.projeto_academia.entities.Pessoa;
import com.cefet.projeto_academia.repositories.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Buscar todos
    public List<PessoaDTO> findAll() {
        List<Pessoa> listaPessoa = pessoaRepository.findAll();
        return listaPessoa.stream().map(PessoaDTO::new).toList();
    }

    // Buscar por ID
    public PessoaDTO findById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));
        return new PessoaDTO(pessoa);
    }

    // Inserir Pessoa
    public PessoaDTO insert(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setEndereco(pessoaDTO.getEndereco());
        pessoa.setTelefone(pessoaDTO.getTelefone());
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoaSalva);
    }

    // Atualizar Pessoa
    public PessoaDTO update(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setEndereco(pessoaDTO.getEndereco());
        pessoa.setTelefone(pessoaDTO.getTelefone());
        Pessoa pessoaAtualizada = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoaAtualizada);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pessoa não encontrada com ID: " + id);
        }
        pessoaRepository.deleteById(id);
    }

}
