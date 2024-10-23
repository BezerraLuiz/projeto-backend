package com.example.demo.models;

public class JogadorModel {
    private String nome;
    private String nick;
    private Integer habilidade;
    private Integer idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Integer habilidade) {
        this.habilidade = habilidade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
