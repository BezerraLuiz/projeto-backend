package com.example.exercicio13.dto;

import jakarta.validation.constraints.NotBlank;

public class JogadorDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Apelido é obrigatório")
    private String apelido;

    // Getters e Setters

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Apelido é obrigatório") String getApelido() {
        return apelido;
    }

    public void setApelido(@NotBlank(message = "Apelido é obrigatório") String apelido) {
        this.apelido = apelido;
    }
}
