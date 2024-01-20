package com.minhasDespesas.dto;

import com.minhasDespesas.model.TipoMovimentacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record MovimentacaoDto (Long id,
                              @NotEmpty TipoMovimentacao tipoMovimentacao,
                              @NotBlank String nome,
                              @NotBlank String email,
                              @NotBlank String senha){
}
