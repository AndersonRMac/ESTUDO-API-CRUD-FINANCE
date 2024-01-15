package com.minhasDespesas.service;

import com.minhasDespesas.model.Movimentacao;
import com.minhasDespesas.repository.MovimantacaoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController ("/movimentacao")
public class MovimentacaoService {

    MovimantacaoRepository movimantacaoRepository;

    @PostMapping
    public ResponseEntity cadastraMovimentacao(@RequestBody @Valid Movimentacao movimentacao){

        movimantacaoRepository.save(movimentacao);
        return ResponseEntity.ok("Movimentação Cadastrada com Sucesso!!");
    }

    @GetMapping
    public ResponseEntity consultaMovimentacao(){
        movimantacaoRepository.findAll();
        return ResponseEntity.ok().build();
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

    @DeleteMapping
    public ResponseEntity deleteMovimentacao(@RequestBody @Valid Movimentacao movimentacao){
        Movimentacao movimentacaoASerDeletada = movimantacaoRepository.getReferenceById(movimentacao.getId());
        movimantacaoRepository.delete(movimentacaoASerDeletada);
        return ResponseEntity.ok("Movimentação Excluida com Sucesso!!");
    }
}
