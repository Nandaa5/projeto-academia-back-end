package com.cefet.projeto_academia.dto;

import java.sql.Date;

import com.cefet.projeto_academia.entities.Matricula;
import com.cefet.projeto_academia.entities.Pessoa;
import com.cefet.projeto_academia.entities.Plano;

public class MatriculaDTO {
    private long id;
    private String numero;
    private Date data;
    private String situacao;
    private Plano plano;
    private Pessoa pessoa;

    public MatriculaDTO() {

    }

    public MatriculaDTO(Matricula matricula) {
        this.id = matricula.getId();
        this.numero = matricula.getNumero();
        this.data = matricula.getData();
        this.situacao = matricula.getSituacao();
        this.plano = matricula.getPlano();
        this.pessoa = matricula.getPessoa();

    }
    
    public long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public String getSituacao() {
        return situacao;
    }

    public Plano getPlano() {
        return plano;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }   

}
