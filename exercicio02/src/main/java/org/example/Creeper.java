package org.example;

public class Creeper extends Personagem {
    @Override
    public void atacar(Personagem alvo) {
        System.out.println(alvo.nome + " foi atacado pelo " + this.nome);
        alvo.vida -= 30;
        this.vida = 0;
    }
}
