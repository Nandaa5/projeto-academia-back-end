package com.cefet.projeto_academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto_academia.dto.FichaDTO;
import com.cefet.projeto_academia.entities.Ficha;
import com.cefet.projeto_academia.repositories.FichaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    // Buscar todos
    public List<FichaDTO> findAll() {
        List<Ficha> listaFichas = fichaRepository.findAll();
        return listaFichas.stream().map(FichaDTO::new).toList();
    }

    // Buscar por ID
    public FichaDTO findById(Long id) {
        Ficha ficha = fichaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ficha não encontrada com ID: " + id));
        return new FichaDTO(ficha);
    }

    // Inserir Ficha
    public FichaDTO insert(FichaDTO fichaDTO) {
        Ficha ficha = new Ficha();
        ficha.setData(fichaDTO.getData());
        ficha.setDescricao(fichaDTO.getDescricao());
        ficha.setSituacao(fichaDTO.getSituacao());
        ficha.setPessoa(fichaDTO.getPessoa()); // Assumindo relacionamento com Pessoa
        Ficha fichaSalva = fichaRepository.save(ficha);
        return new FichaDTO(fichaSalva);
    }

    // Atualizar Ficha
    public FichaDTO update(Long id, FichaDTO fichaDTO) {
        Ficha ficha = fichaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ficha não encontrada com ID: " + id));
        ficha.setData(fichaDTO.getData());
        ficha.setDescricao(fichaDTO.getDescricao());
        ficha.setSituacao(fichaDTO.getSituacao());
        ficha.setPessoa(fichaDTO.getPessoa()); // Atualiza pessoa associada, se necessário
        Ficha fichaAtualizada = fichaRepository.save(ficha);
        return new FichaDTO(fichaAtualizada);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!fichaRepository.existsById(id)) {
            throw new EntityNotFoundException("Ficha não encontrada com ID: " + id);
        }
        fichaRepository.deleteById(id);
    }

}
