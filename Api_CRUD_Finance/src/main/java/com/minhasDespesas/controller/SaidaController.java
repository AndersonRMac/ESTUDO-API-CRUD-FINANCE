package com.minhasDespesas.controller;

import com.minhasDespesas.dto.SaidaDto;
import com.minhasDespesas.model.SaidaModel;
import com.minhasDespesas.repository.SaidaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saida")
public class SaidaController {

    @Autowired
    SaidaRepository saidaRepository;

    @PostMapping
    public ResponseEntity cadastraSaida (@RequestBody @Valid SaidaDto saidaDto){
        SaidaModel novaSaida = new SaidaModel(saidaDto);
        saidaRepository.save(novaSaida);
        return ResponseEntity.ok(novaSaida + "Saida cadastrada com Sucesso!");
    }

    @GetMapping
    public ResponseEntity retornaSaida (){
        List<SaidaModel> saidasCadastradas = saidaRepository.findAll();
        return ResponseEntity.ok(saidasCadastradas);
    }

    @PutMapping
    public ResponseEntity alteraSaida(@RequestBody @Valid SaidaDto saidaDto){
        SaidaModel saidaAlterada = saidaRepository.getReferenceById(saidaDto.id());
        saidaAlterada.setNome(saidaDto.nome());
        saidaAlterada.setValor(saidaDto.valor());
        saidaAlterada.setVencimento(saidaDto.vencimento());
        saidaRepository.save(saidaAlterada);

        return ResponseEntity.ok("Saida alterada com sucesso!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletaSaida(@PathVariable  Long id){
         saidaRepository.deleteById(id);
         return ResponseEntity.ok("Cadastro excluído com sucesso!");
    }

}
