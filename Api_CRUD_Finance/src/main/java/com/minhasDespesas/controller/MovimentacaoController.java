package com.minhasDespesas.controller;

import com.minhasDespesas.dto.MovimentacaoEntradaDto;
import com.minhasDespesas.dto.MovimentacaoSaidaDto;
import com.minhasDespesas.model.Movimentacao;
import com.minhasDespesas.service.MovimentacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping("/entrada")
    public ResponseEntity cadastraEntrada(@RequestBody @Valid MovimentacaoEntradaDto movimentacaoEntradaDto){
        movimentacaoService.cadastraEntrada(movimentacaoEntradaDto);
        return ResponseEntity.ok("Entrada Cadastrada com Sucesso!!");
    }

    @PostMapping("/saida")
    public ResponseEntity cadastraSaida(@RequestBody @Valid MovimentacaoSaidaDto movimentacaoSaidaDto){
        movimentacaoService.cadastraSaida(movimentacaoSaidaDto);
        return ResponseEntity.ok("Saida Cadastrada com Sucesso!!");
    }

    @GetMapping
    public ResponseEntity consultaMovimentacao(){

        return ResponseEntity.ok(movimentacaoService.consultaMovimentacao());
    }

    @PutMapping
    public ResponseEntity alteraMovimentacao(@RequestBody @Valid Movimentacao movimentacao){
        movimentacaoService.alteraMovimentacao(movimentacao);
        return ResponseEntity.ok("Movimentação Alterada com Sucesso!!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovimentacao(@PathVariable Long id){
        movimentacaoService.deleteMovimentacao(id);
        return ResponseEntity.ok("Movimentação Excluida com Sucesso!!");
    }
}