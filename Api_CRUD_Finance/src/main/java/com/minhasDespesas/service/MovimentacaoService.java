package com.minhasDespesas.service;

import com.minhasDespesas.dto.MovimentacaoEntradaDto;
import com.minhasDespesas.dto.MovimentacaoSaidaDto;
import com.minhasDespesas.model.Movimentacao;
import com.minhasDespesas.repository.MovimantacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    MovimantacaoRepository movimantacaoRepository;

    public Movimentacao cadastraEntrada(MovimentacaoEntradaDto movimentacaoEntradaDto){
        Movimentacao novaMovimentacao = new Movimentacao(movimentacaoEntradaDto);
        movimantacaoRepository.save(novaMovimentacao);
        return novaMovimentacao;
    }

    public Movimentacao cadastraSaida(MovimentacaoSaidaDto movimentacaoSaidaDto){
        Movimentacao novaMovimentacao = new Movimentacao(movimentacaoSaidaDto);
        movimantacaoRepository.save(novaMovimentacao);
        return novaMovimentacao;
    }

    public List<Movimentacao> consultaMovimentacao(){
        List<Movimentacao> consultaMovimentacoes = movimantacaoRepository.findAll();
        return consultaMovimentacoes;
    }

    public Movimentacao alteraMovimentacao(Movimentacao movimentacao){

        Movimentacao movimentacaoAtualizada = movimantacaoRepository.getReferenceById(movimentacao.getId());
        movimentacaoAtualizada.setId(movimentacao.getId());
        movimentacaoAtualizada.setNome(movimentacao.getNome());
        movimentacaoAtualizada.setValor(movimentacao.getValor());
        movimentacaoAtualizada.setVencimento(movimentacao.getVencimento());
        movimantacaoRepository.save(movimentacaoAtualizada);
        return movimentacaoAtualizada;
    }

    public Movimentacao deleteMovimentacao(Long id){
        Movimentacao movimentacaoASerDeletada = movimantacaoRepository.getReferenceById(id);
        movimantacaoRepository.delete(movimentacaoASerDeletada);
        return movimentacaoASerDeletada;
    }
}

