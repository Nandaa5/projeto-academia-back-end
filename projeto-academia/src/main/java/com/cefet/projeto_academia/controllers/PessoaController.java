package com.cefet.projeto_academia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefet.projeto_academia.dto.PessoaDTO;
import com.cefet.projeto_academia.services.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/pessoas")
@Tag(name = "Pessoas", description = "Operações relacionadas a pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pessoa por ID", description = "Retorna os dados de uma pessoa específica.") 
    public ResponseEntity<PessoaDTO> findById(
            @Parameter(description = "ID da pessoa a ser buscada", example = "1") 
            @PathVariable Long id) {
        PessoaDTO pessoaDTO = pessoaService.findById(id);
        return ResponseEntity.ok(pessoaDTO);
    }

    @GetMapping
    @Operation(summary = "Listar todas as pessoas", description = "Retorna a lista de todas as pessoas cadastradas.")
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<PessoaDTO> pessoaDTOs = pessoaService.findAll();
        return ResponseEntity.ok(pessoaDTOs);
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova pessoa", description = "Cria uma nova pessoa no banco de dados.")
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO novaPessoa = pessoaService.insert(pessoaDTO);
        return ResponseEntity.status(201).body(novaPessoa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma pessoa", description = "Atualiza os dados de uma pessoa existente.")
    public ResponseEntity<PessoaDTO> update(
            @Parameter(description = "ID da pessoa a ser atualizada") @PathVariable Long id, 
            @RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO pessoaAtualizada = pessoaService.update(id, pessoaDTO);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma pessoa", description = "Remove uma pessoa do banco de dados.")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID da pessoa a ser deletada") @PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}