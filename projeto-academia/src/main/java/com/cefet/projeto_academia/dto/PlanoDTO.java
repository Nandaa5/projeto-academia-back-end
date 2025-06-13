package com.cefet.projeto_academia.dto;

import com.cefet.projeto_academia.entities.Plano;

public class PlanoDTO {
    private long id;
    private String descricao;
    private long parcelas;
    private double valor;

    public PlanoDTO() {

    }

    public PlanoDTO(Plano plano) {
        this.id = plano.getId();
        this.descricao = plano.getDescricao();
        this.parcelas = plano.getParcelas();
        this.valor = plano.getValor();
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public long getParcelas() {
        return parcelas;
    }

    public double getValor() {
        return valor;
    }

}
