package com.cefet.projeto_academia.dto;

import com.cefet.projeto_academia.entities.Ficha;
import com.cefet.projeto_academia.entities.Pessoa;

public class FichaDTO {
    private long id;
    private String data;
    private String descricao;
    private String situacao;
    private Pessoa pessoa;

    public FichaDTO() {

    }

    public FichaDTO(Ficha ficha) {
        this.id = ficha.getId();
        this.data = ficha.getData();
        this.descricao = ficha.getDescricao();
        this.situacao = ficha.getSituacao();
        this.pessoa = ficha.getPessoa();

    }

    public long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

}
