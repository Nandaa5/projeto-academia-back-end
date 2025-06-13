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

import com.cefet.projeto_academia.dto.FichaDTO;
import com.cefet.projeto_academia.services.FichaService;

@RestController
@RequestMapping("/fichas")
public class FichaController {

    @Autowired
    private FichaService fichaService;

    @GetMapping("/{id}")
    public ResponseEntity<FichaDTO> findById(@PathVariable Long id) {
        FichaDTO fichaDTO = fichaService.findById(id);
        return ResponseEntity.ok(fichaDTO);
    }

    @GetMapping
    public ResponseEntity<List<FichaDTO>> findAll() {
        List<FichaDTO> fichasDTOs = fichaService.findAll();
        return ResponseEntity.ok(fichasDTOs);
    }

    @PostMapping
    public ResponseEntity<FichaDTO> create(@RequestBody FichaDTO fichaDTO) {
        FichaDTO novaFicha = fichaService.insert(fichaDTO);
        return ResponseEntity.status(201).body(novaFicha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaDTO> update(@PathVariable Long id, @RequestBody FichaDTO fichaDTO) {
        FichaDTO fichaAtualizada = fichaService.update(id, fichaDTO);
        return ResponseEntity.ok(fichaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fichaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    

}
