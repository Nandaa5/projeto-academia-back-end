package com.cefet.projeto_academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto_academia.dto.ExercicioDTO;
import com.cefet.projeto_academia.entities.Exercicio;
import com.cefet.projeto_academia.repositories.ExercicioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    // Buscar todos
    public List<ExercicioDTO> findAll() {
        List<Exercicio> listaExercicio = exercicioRepository.findAll();
        return listaExercicio.stream().map(ExercicioDTO::new).toList();
    }

    // Buscar por ID
    public ExercicioDTO findById(Long id) {
        Exercicio exercicio = exercicioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exercício não encontrado com ID: " + id));
        return new ExercicioDTO(exercicio);
    }

    // Inserir Exercício
    public ExercicioDTO insert(ExercicioDTO exercicioDTO) {
        Exercicio exercicio = new Exercicio();
        exercicio.setNome(exercicioDTO.getNome());
        Exercicio exercicioSalvo = exercicioRepository.save(exercicio);
        return new ExercicioDTO(exercicioSalvo);
    }

    // Atualizar Exercício
    public ExercicioDTO update(Long id, ExercicioDTO exercicioDTO) {
        Exercicio exercicio = exercicioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exercício não encontrado com ID: " + id));
        exercicio.setNome(exercicioDTO.getNome());
        Exercicio exercicioAtualizado = exercicioRepository.save(exercicio);
        return new ExercicioDTO(exercicioAtualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!exercicioRepository.existsById(id)) {
            throw new EntityNotFoundException("Exercício não encontrado com ID: " + id);
        }
        exercicioRepository.deleteById(id);
    }

}
