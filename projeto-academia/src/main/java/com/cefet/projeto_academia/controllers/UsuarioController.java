package com.cefet.projeto_academia.controllers;

import com.cefet.projeto_academia.dto.UsuarioDTO;
import com.cefet.projeto_academia.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operações relacionadas a usuários do sistema")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por ID", description = "Retorna os dados de um usuário específico.")
    public ResponseEntity<UsuarioDTO> findById(
            @Parameter(description = "ID do usuário a ser buscado", example = "1")
            @PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping
    @Operation(summary = "Listar todos os usuários", description = "Retorna a lista de todos os usuários cadastrados. Requer permissão de ADMIN.")
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> usuariosDTOs = usuarioService.findAll();
        return ResponseEntity.ok(usuariosDTOs);
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo usuário", description = "Cria um novo usuário no sistema. Este endpoint é público.")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO novoUsuario = usuarioService.insert(usuarioDTO);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um usuário", description = "Atualiza os dados de um usuário existente. Requer permissão de ADMIN.")
    public ResponseEntity<UsuarioDTO> update(
            @Parameter(description = "ID do usuário a ser atualizado")
            @PathVariable Long id, 
            @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioAtualizado = usuarioService.update(id, usuarioDTO);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um usuário", description = "Remove um usuário do sistema. Requer permissão de ADMIN.")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do usuário a ser deletado")
            @PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
