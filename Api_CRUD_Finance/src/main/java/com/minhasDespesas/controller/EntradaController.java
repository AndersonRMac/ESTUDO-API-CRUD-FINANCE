package com.minhasDespesas.controller;

import com.minhasDespesas.dto.EntradaDto;
import com.minhasDespesas.model.EntradaModel;
import com.minhasDespesas.repository.EntradaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrada")
public class EntradaController {

    @Autowired
    EntradaRepository entradaRepository;

    @PostMapping
    public ResponseEntity cadastraEntrada(@RequestBody @Valid EntradaDto entradaDto){
        EntradaModel novaEntrada = new EntradaModel(entradaDto);
        entradaRepository.save(novaEntrada);
        return ResponseEntity.ok("Entrada Cadastrada com sucesso!");

    }

    @GetMapping(value = "{id}")
    public ResponseEntity consultaEntradasById(@PathVariable Long id){
        entradaRepository.getReferenceById(id);
        return ResponseEntity.ok(id);
    }

}
