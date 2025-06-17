package com.cefet.projeto_academia.dto;

import com.cefet.projeto_academia.entities.Exercicio;
import com.cefet.projeto_academia.entities.Ficha;
import com.cefet.projeto_academia.entities.FichaExercicio;

public class FichaExercicioDTO {
    private long id;
    private long series;
    private long repeticoes;
    private Exercicio exercicio;
    private Ficha ficha;

    public FichaExercicioDTO(){

    }

    public FichaExercicioDTO(FichaExercicio fichaExercicio){
        this.id = fichaExercicio.getId();
        this.series = fichaExercicio.getSeries();
        this.repeticoes = fichaExercicio.getRepeticoes();
        this.exercicio = fichaExercicio.getExercicio();
        this.ficha = fichaExercicio.getFicha();
    }

    public long getId() {
        return id;
    }

    public long getSeries() {
        return series;
    }

    public long getRepeticoes() {
        return repeticoes;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public Ficha getFicha() {
        return ficha;
    }
    
    
}
