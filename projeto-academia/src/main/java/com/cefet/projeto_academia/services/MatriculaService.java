package com.cefet.projeto_academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto_academia.dto.MatriculaDTO;
import com.cefet.projeto_academia.entities.Matricula;
import com.cefet.projeto_academia.repositories.MatriculaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    // Buscar todos
    public List<MatriculaDTO> findAll() {
        List<Matricula> listaMatriculas = matriculaRepository.findAll();
        return listaMatriculas.stream().map(MatriculaDTO::new).toList();
    }

    // Buscar por ID
    public MatriculaDTO findById(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matrícula não encontrada com ID: " + id));
        return new MatriculaDTO(matricula);
    }

    // Inserir Matricula
    public MatriculaDTO insert(MatriculaDTO matriculaDTO) {
        Matricula matricula = new Matricula();
        matricula.setNumero(matriculaDTO.getNumero());
        matricula.setData(matriculaDTO.getData());
        matricula.setSituacao(matriculaDTO.getSituacao());
        matricula.setPlano(matriculaDTO.getPlano()); // FK Plano
        matricula.setPessoa(matriculaDTO.getPessoa()); // FK Pessoa
        Matricula matriculaSalva = matriculaRepository.save(matricula);
        return new MatriculaDTO(matriculaSalva);
    }

    // Atualizar Matricula
    public MatriculaDTO update(Long id, MatriculaDTO matriculaDTO) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matrícula não encontrada com ID: " + id));
        matricula.setNumero(matriculaDTO.getNumero());
        matricula.setData(matriculaDTO.getData());
        matricula.setSituacao(matriculaDTO.getSituacao());
        matricula.setPlano(matriculaDTO.getPlano()); // FK Plano
        matricula.setPessoa(matriculaDTO.getPessoa()); // FK Pessoa
        Matricula matriculaAtualizada = matriculaRepository.save(matricula);
        return new MatriculaDTO(matriculaAtualizada);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!matriculaRepository.existsById(id)) {
            throw new EntityNotFoundException("Matrícula não encontrada com ID: " + id);
        }
        matriculaRepository.deleteById(id);
    }

    
}
