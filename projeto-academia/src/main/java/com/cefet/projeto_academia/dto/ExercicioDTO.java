package com.cefet.projeto_academia.dto;

import com.cefet.projeto_academia.entities.Exercicio;

public class ExercicioDTO {
    private long id;
    private String nome;

    public ExercicioDTO() {

    }

    public ExercicioDTO(Exercicio exercicio) {
        this.id = exercicio.getId();
        this.nome = exercicio.getNome();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
