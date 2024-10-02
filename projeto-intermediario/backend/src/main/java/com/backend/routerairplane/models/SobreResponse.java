package com.backend.routerairplane.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"estudante", "projeto"})
public class SobreResponse {
    private String estudante;
    private String projeto;

    public SobreResponse(String estudante, String projeto) {
        this.estudante = estudante;
        this.projeto = projeto;
    }

    // getters and setters
    public String getEstudante() {
        return estudante;
    }

    public void setEstudante(String message) {
        this.estudante = message;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }
}
