package com.minhasDespesas.controller;

import com.minhasDespesas.dto.EntradaDto;
import com.minhasDespesas.model.EntradaModel;
import com.minhasDespesas.repository.EntradaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrada")
public class EntradaController {

    @Autowired
    EntradaRepository entradaRepository;

    @PostMapping
    public ResponseEntity cadastraEntrada(@RequestBody @Valid EntradaDto entradaDto){
        System.out.println(entradaDto);
        EntradaModel novaEntrada = new EntradaModel(entradaDto);
        entradaRepository.save(novaEntrada);
        return ResponseEntity.ok("Entrada Cadastrada com sucesso!");

    }

    @GetMapping
    public ResponseEntity consultaTodasAsEntradas(){
        List<EntradaModel> todasAsEntradas =  entradaRepository.findAll();
        return ResponseEntity.ok(todasAsEntradas);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletaEntradaCadastrada(@PathVariable Long id){
        entradaRepository.deleteById(id);
        return ResponseEntity.ok("Entrada excluída com sucesso!");
    }

    @PutMapping
    public ResponseEntity atualizaEntrada(@RequestBody EntradaDto entradaDto){
            EntradaModel entradaAtualizada = entradaRepository.getReferenceById(entradaDto.id());
            entradaAtualizada.setNome(entradaDto.nome());
            entradaAtualizada.setValor(entradaDto.valor());
            entradaRepository.save(entradaAtualizada);
            return ResponseEntity.ok("Entrada atualizada com Sucesso");
    }

}
