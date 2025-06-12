package com.cefet.projeto_academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto_academia.dto.PlanoDTO;
import com.cefet.projeto_academia.entities.Plano;
import com.cefet.projeto_academia.repositories.PlanoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    // Buscar todos
    public List<PlanoDTO> findAll() {
        List<Plano> listaPlano = planoRepository.findAll();
        return listaPlano.stream().map(PlanoDTO::new).toList();
    }

    // Buscar por ID
    public PlanoDTO findById(Long id) {
        Plano plano = planoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plano não encontrado com ID: " + id));
        return new PlanoDTO(plano);
    }

    // Inserir Plano
    public PlanoDTO insert(PlanoDTO planoDTO) {
        Plano plano = new Plano();
        plano.setDescricao(planoDTO.getDescricao());
        plano.setParcelas(planoDTO.getParcelas());
        plano.setValor(planoDTO.getValor());
        Plano planoSalvo = planoRepository.save(plano);
        return new PlanoDTO(planoSalvo);
    }

    // Atualizar Plano
    public PlanoDTO update(Long id, PlanoDTO planoDTO) {
        Plano plano = planoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plano não encontrado com ID: " + id));
        plano.setDescricao(planoDTO.getDescricao());
        plano.setParcelas(planoDTO.getParcelas());
        plano.setValor(planoDTO.getValor());
        Plano planoAtualizado = planoRepository.save(plano);
        return new PlanoDTO(planoAtualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!planoRepository.existsById(id)) {
            throw new EntityNotFoundException("Plano não encontrado com ID: " + id);
        }
        planoRepository.deleteById(id);
    }

}
