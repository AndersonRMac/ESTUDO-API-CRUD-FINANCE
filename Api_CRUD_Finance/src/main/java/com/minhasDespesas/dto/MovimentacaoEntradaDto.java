package com.minhasDespesas.dto;

import com.minhasDespesas.model.TipoMovimentacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovimentacaoEntradaDto( Long id,
                                     @NotNull TipoMovimentacao tipoMovimentacao,
                                     @NotBlank String nome,
                                     @NotNull Double valor){
}
