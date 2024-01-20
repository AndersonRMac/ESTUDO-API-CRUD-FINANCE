package com.minhasDespesas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDto(@NotNull Long id,
                         @NotBlank String nome,
                         @NotBlank String email,
                         @NotBlank String senha) {
}

/*
"Record" -  É uma forma de criar um dto;
*/
