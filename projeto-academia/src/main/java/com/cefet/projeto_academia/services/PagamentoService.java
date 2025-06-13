package com.cefet.projeto_academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto_academia.dto.PagamentoDTO;
import com.cefet.projeto_academia.entities.Pagamento;
import com.cefet.projeto_academia.repositories.PagamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PagamentoService {
    
     @Autowired
     private PagamentoRepository pagamentoRepository;

      // Buscar todos
    public List<PagamentoDTO> findAll() {
        List<Pagamento> listaPagamentos = pagamentoRepository.findAll();
        return listaPagamentos.stream().map(PagamentoDTO::new).toList();
    }

    // Buscar por ID
    public PagamentoDTO findById(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado com ID: " + id));
        return new PagamentoDTO(pagamento);
    }

    // Inserir Pagamento
    public PagamentoDTO insert(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setDataVencimento(pagamentoDTO.getDataVencimento());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());
        pagamento.setValor(pagamentoDTO.getValor());
        pagamento.setMatricula(pagamentoDTO.getMatricula()); // Assumindo relacionamento com Matricula
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
        return new PagamentoDTO(pagamentoSalvo);
    }

    // Atualizar Pagamento
    public PagamentoDTO update(Long id, PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado com ID: " + id));
        pagamento.setDataVencimento(pagamentoDTO.getDataVencimento());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());
        pagamento.setValor(pagamentoDTO.getValor());
        pagamento.setMatricula(pagamentoDTO.getMatricula());
        Pagamento pagamentoAtualizado = pagamentoRepository.save(pagamento);
        return new PagamentoDTO(pagamentoAtualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!pagamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Pagamento não encontrado com ID: " + id);
        }
        pagamentoRepository.deleteById(id);
    }
}
