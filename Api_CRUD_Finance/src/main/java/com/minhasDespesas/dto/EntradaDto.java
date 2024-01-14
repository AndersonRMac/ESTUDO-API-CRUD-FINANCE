package com.minhasDespesas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntradaDto ( Long id,
                           @NotBlank String nome,
                           @NotNull Integer valor){
}
/*
Usei @NotBlank para Integer e deu errado,
o certo era notNull
 */