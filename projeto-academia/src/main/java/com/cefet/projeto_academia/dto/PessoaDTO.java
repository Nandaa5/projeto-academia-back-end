package com.cefet.projeto_academia.dto;

import com.cefet.projeto_academia.entities.Pessoa;

public class PessoaDTO {
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public PessoaDTO() {

    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.endereco = pessoa.getEndereco();
        this.telefone = pessoa.getTelefone();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

}
