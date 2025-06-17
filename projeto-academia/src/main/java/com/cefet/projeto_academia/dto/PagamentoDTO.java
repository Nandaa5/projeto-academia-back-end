package com.cefet.projeto_academia.dto;

import java.sql.Date;

import com.cefet.projeto_academia.entities.Matricula;
import com.cefet.projeto_academia.entities.Pagamento;


public class PagamentoDTO {
    private long id;
    private Date dataVencimento;
    private Date dataPagamento;
    private double valor;
    private Matricula matricula;
    
    public PagamentoDTO(){

    }

    public PagamentoDTO(Pagamento pagamento){
        this.id = pagamento.getId();
        this.dataVencimento = pagamento.getDataVencimento();
        this.dataPagamento = pagamento.getDataPagamento();
        this.valor = pagamento.getValor();
        this.matricula = pagamento.getMatricula();
    }

    public long getId() {
        return id;
    }


    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public Matricula getMatricula() {
        return matricula;
    }
    
}
