package com.cefet.projeto_academia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ficha_exercicio")
public class FichaExercicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private long series;

    @Column(nullable = false)
    private long repeticoes;

    @ManyToOne 
    @JoinColumn(name= "id_exercicio")
    private Exercicio exercicio;

    @ManyToOne 
    @JoinColumn(name= "id_ficha")
    private Ficha ficha;

    public FichaExercicio(){

    }

    public FichaExercicio(Long id, long series, long repeticoes, Exercicio exercicio, Ficha ficha) {
        this.id = id;
        this.series = series;
        this.repeticoes = repeticoes;
        this.exercicio = exercicio;
        this.ficha = ficha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSeries() {
        return series;
    }

    public void setSeries(long series) {
        this.series = series;
    }

    public long getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(long repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FichaExercicio other = (FichaExercicio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
