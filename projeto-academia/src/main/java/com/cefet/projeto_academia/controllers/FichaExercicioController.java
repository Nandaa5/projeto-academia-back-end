package com.cefet.projeto_academia.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.projeto_academia.dto.FichaExercicioDTO;
import com.cefet.projeto_academia.services.FichaExercicioService;

@RestController
@RequestMapping("/fichaExercicios")
public class FichaExercicioController {

    @Autowired
    private FichaExercicioService fichaExercicioService;

    @GetMapping("/{id}")
    public ResponseEntity<FichaExercicioDTO> findById(@PathVariable Long id) {
        FichaExercicioDTO fichaExercicioDTO = fichaExercicioService.findById(id);
        return ResponseEntity.ok(fichaExercicioDTO);
    }

    @GetMapping
    public ResponseEntity<List<FichaExercicioDTO>> findAll() {
        List<FichaExercicioDTO> fichaExerciciosDTOs = fichaExercicioService.findAll();
        return ResponseEntity.ok(fichaExerciciosDTOs);
    }

    @PostMapping
    public ResponseEntity<FichaExercicioDTO> create(@RequestBody FichaExercicioDTO fichaExercicioDTO) {
        FichaExercicioDTO novaFichaExercicio = fichaExercicioService.insert(fichaExercicioDTO);
        return ResponseEntity.status(201).body(novaFichaExercicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaExercicioDTO> update(@PathVariable Long id, @RequestBody FichaExercicioDTO fichaExercicioDTO) {
        FichaExercicioDTO fichaExercicioAtualizada = fichaExercicioService.update(id, fichaExercicioDTO);
        return ResponseEntity.ok(fichaExercicioAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fichaExercicioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
