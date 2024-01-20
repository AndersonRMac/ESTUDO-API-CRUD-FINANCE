package com.minhasDespesas.dto;

import com.minhasDespesas.model.TipoMovimentacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MovimentacaoUsuarioDto (@NotNull Long id,
                              @NotEmpty TipoMovimentacao tipoMovimentacao,
                              @NotBlank String nome,
                              @NotBlank String email,
                              @NotBlank String senha){
}
