package com.minhasDespesas.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(Long id,
                         @NotBlank String nome,
                         @NotBlank String email,
                         @NotBlank String senha) {
}

/*
"Record" -  É uma forma de criar um dto;
*/
