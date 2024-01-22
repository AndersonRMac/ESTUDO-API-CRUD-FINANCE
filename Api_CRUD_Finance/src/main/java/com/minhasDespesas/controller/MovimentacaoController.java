package com.minhasDespesas.controller;

import com.minhasDespesas.dto.MovimentacaoEntradaDto;
import com.minhasDespesas.dto.MovimentacaoSaidaDto;
import com.minhasDespesas.model.Movimentacao;
import com.minhasDespesas.repository.MovimantacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimantacaoRepository movimantacaoRepository;

    @PostMapping("/entrada")
    public ResponseEntity cadastraEntrada(@RequestBody @Valid MovimentacaoEntradaDto movimentacaoEntradaDto){
        Movimentacao novaMovimentacao = new Movimentacao(movimentacaoEntradaDto);
        movimantacaoRepository.save(novaMovimentacao);
        return ResponseEntity.ok("Entrada Cadastrada com Sucesso!!");
    }

    @PostMapping("/saida")
    public ResponseEntity cadastraSaida(@RequestBody @Valid MovimentacaoSaidaDto movimentacaoSaidaDto){
        Movimentacao novaMovimentacao = new Movimentacao(movimentacaoSaidaDto);
        movimantacaoRepository.save(novaMovimentacao);
        return ResponseEntity.ok("Saida Cadastrada com Sucesso!!");
    }

    @GetMapping
    public ResponseEntity consultaMovimentacao(){
        List<Movimentacao> ConsultaMovimentacoes = movimantacaoRepository.findAll();
        return ResponseEntity.ok(ConsultaMovimentacoes);
    }

    @PutMapping
    public ResponseEntity alteraMovimentacao(@RequestBody @Valid Movimentacao movimentacao){

        Movimentacao movimentacaoAtualizada = movimantacaoRepository.getReferenceById(movimentacao.getId());
        movimentacaoAtualizada.setId(movimentacao.getId());
        movimentacaoAtualizada.setNome(movimentacao.getNome());
        movimentacaoAtualizada.setValor(movimentacao.getValor());
        movimentacaoAtualizada.setVencimento(movimentacao.getVencimento());
        movimantacaoRepository.save(movimentacaoAtualizada);
        return ResponseEntity.ok("Movimentação Alterada com Sucesso!!");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovimentacao(@PathVariable Long id){
        Movimentacao movimentacaoASerDeletada = movimantacaoRepository.getReferenceById(id);
        movimantacaoRepository.delete(movimentacaoASerDeletada);
        return ResponseEntity.ok("Movimentação Excluida com Sucesso!!");
    }
}
