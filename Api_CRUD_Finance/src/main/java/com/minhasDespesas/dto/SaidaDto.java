package com.minhasDespesas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SaidaDto(Long id,
                       @NotBlank String nome,
                       @NotNull Double valor,
                       @NotBlank String vencimento) {
}
