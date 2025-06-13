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

import com.cefet.projeto_academia.dto.MatriculaDTO;
import com.cefet.projeto_academia.services.MatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> findById(@PathVariable Long id) {
        MatriculaDTO matriculaDTO = matriculaService.findById(id);
        return ResponseEntity.ok(matriculaDTO);
    }

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAll() {
        List<MatriculaDTO> matriculasDTOs = matriculaService.findAll();
        return ResponseEntity.ok(matriculasDTOs);
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> create(@RequestBody MatriculaDTO matriculaDTO) {
        MatriculaDTO novaMatricula = matriculaService.insert(matriculaDTO);
        return ResponseEntity.status(201).body(novaMatricula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@PathVariable Long id, @RequestBody MatriculaDTO matriculaDTO) {
        MatriculaDTO matriculaAtualizada = matriculaService.update(id, matriculaDTO);
        return ResponseEntity.ok(matriculaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
