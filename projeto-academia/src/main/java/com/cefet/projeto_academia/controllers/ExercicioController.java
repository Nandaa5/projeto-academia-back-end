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

import com.cefet.projeto_academia.dto.ExercicioDTO;
import com.cefet.projeto_academia.services.ExercicioService;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {
    
     @Autowired
    private ExercicioService exercicioService;

     @GetMapping("/{id}")
    public ResponseEntity<ExercicioDTO> findById(@PathVariable Long id) {
        ExercicioDTO exercicioDTO = exercicioService.findById(id);
        return ResponseEntity.ok(exercicioDTO);
    }

    @GetMapping
    public ResponseEntity<List<ExercicioDTO>> findAll() {
        List<ExercicioDTO> exercicioDTOs = exercicioService.findAll();
        return ResponseEntity.ok(exercicioDTOs);
    }

    @PostMapping
    public ResponseEntity<ExercicioDTO> create(@RequestBody ExercicioDTO exercicioDTO) {
        ExercicioDTO novoExercicio = exercicioService.insert(exercicioDTO);
        return ResponseEntity.status(201).body(novoExercicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExercicioDTO> update(@PathVariable Long id, @RequestBody ExercicioDTO exercicioDTO) {
        ExercicioDTO exercicioAtualizado = exercicioService.update(id, exercicioDTO);
        return ResponseEntity.ok(exercicioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        exercicioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
