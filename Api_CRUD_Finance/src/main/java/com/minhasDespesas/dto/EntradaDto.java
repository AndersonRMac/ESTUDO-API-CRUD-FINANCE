package com.minhasDespesas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntradaDto (@NotNull Long id,
                          @NotBlank String nome,
                          @NotBlank Double valor){
}
