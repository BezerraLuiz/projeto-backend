package com.example.demo.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record JogadorRequestDto(

        @NotNull @Size(min = 1, max = 4) String nome, // Não pode ser nulo.
        @NotBlank String nick, // Não seja em branco.
        @Min(value = 18) Integer idade // Valor mínimo igual a 18.
) {}
