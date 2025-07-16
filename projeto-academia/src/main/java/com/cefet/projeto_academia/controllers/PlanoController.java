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

import com.cefet.projeto_academia.dto.PlanoDTO;
import com.cefet.projeto_academia.services.PlanoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/planos")
@Tag(name = "Planos", description = "Operações relacionadas aos planos da academia")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar plano por ID", description = "Retorna os dados de um plano específico.")
    public ResponseEntity<PlanoDTO> findById(
            @Parameter(description = "ID do plano a ser buscado", example = "1") 
            @PathVariable Long id) {
        PlanoDTO planoDTO = planoService.findById(id);
        return ResponseEntity.ok(planoDTO);
    }

    @GetMapping
    @Operation(summary = "Listar todos os planos", description = "Retorna a lista de todos os planos cadastrados.")
    public ResponseEntity<List<PlanoDTO>> findAll() {
        List<PlanoDTO> planoDTOs = planoService.findAll();
        return ResponseEntity.ok(planoDTOs);
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo plano", description = "Cria um novo plano no banco de dados.")
    public ResponseEntity<PlanoDTO> create(@RequestBody PlanoDTO planoDTO) {
        PlanoDTO novoPlano = planoService.insert(planoDTO);
        return ResponseEntity.status(201).body(novoPlano);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um plano", description = "Atualiza os dados de um plano existente.")
    public ResponseEntity<PlanoDTO> update(
            @Parameter(description = "ID do plano a ser atualizado") 
            @PathVariable Long id, 
            @RequestBody PlanoDTO planoDTO) {
        PlanoDTO planoAtualizado = planoService.update(id, planoDTO);
        return ResponseEntity.ok(planoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um plano", description = "Remove um plano do banco de dados.")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do plano a ser deletado") 
            @PathVariable Long id) {
        planoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}