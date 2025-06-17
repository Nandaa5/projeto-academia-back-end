package com.cefet.projeto_academia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto_academia.dto.FichaExercicioDTO;
import com.cefet.projeto_academia.entities.FichaExercicio;
import com.cefet.projeto_academia.repositories.FichaExercicioRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class FichaExercicioService {

    @Autowired
    private FichaExercicioRepository fichaExercicioRepository;

    // Buscar todos
    public List<FichaExercicioDTO> findAll() {
        List<FichaExercicio> listaFichaExercicio = fichaExercicioRepository.findAll();
        return listaFichaExercicio.stream().map(FichaExercicioDTO::new).toList();
    }

    // Buscar por ID
    public FichaExercicioDTO findById(Long id) {
        FichaExercicio fichaExercicio = fichaExercicioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FichaExercicio não encontrada com ID: " + id));
        return new FichaExercicioDTO(fichaExercicio);
    }

    // Inserir FichaExercicio
    public FichaExercicioDTO insert(FichaExercicioDTO fichaExercicioDTO) {
        FichaExercicio fichaExercicio = new FichaExercicio();
        fichaExercicio.setSeries(fichaExercicioDTO.getSeries());
        fichaExercicio.setRepeticoes(fichaExercicioDTO.getRepeticoes());
        fichaExercicio.setExercicio(fichaExercicioDTO.getExercicio()); // FK Exercicio
        fichaExercicio.setFicha(fichaExercicioDTO.getFicha()); // FK Ficha
        FichaExercicio fichaExercicioSalva = fichaExercicioRepository.save(fichaExercicio);
        return new FichaExercicioDTO(fichaExercicioSalva);
    }

    // Atualizar FichaExercicio
    public FichaExercicioDTO update(Long id, FichaExercicioDTO fichaExercicioDTO) {
        FichaExercicio fichaExercicio = fichaExercicioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FichaExercicio não encontrada com ID: " + id));
        fichaExercicio.setSeries(fichaExercicioDTO.getSeries());
        fichaExercicio.setRepeticoes(fichaExercicioDTO.getRepeticoes());
        fichaExercicio.setExercicio(fichaExercicioDTO.getExercicio()); // FK Exercicio
        fichaExercicio.setFicha(fichaExercicioDTO.getFicha()); // FK Ficha
        FichaExercicio fichaExercicioAtualizada = fichaExercicioRepository.save(fichaExercicio);
        return new FichaExercicioDTO(fichaExercicioAtualizada);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!fichaExercicioRepository.existsById(id)) {
            throw new EntityNotFoundException("FichaExercicio não encontrada com ID: " + id);
        }
        fichaExercicioRepository.deleteById(id);
    }
}
