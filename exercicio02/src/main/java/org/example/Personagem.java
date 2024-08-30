package org.example;

/**
 Crie uma classe chamada Personagem que implemente os atributos nome, vida e ataque, além de dos métodos receberDano e atacar;

 O método receberDano recebe um parâmetro do tipo int que subtrai da vida do objeto. Se o valor da vida for menor ou igual a zero,
 o método deve imprimir uma mensagem informando que o personagem foi derrotado;

 O método atacar recebe um parâmetro do tipo Personagem chamado alvo e chama o método receberDano,
 passando o ataque do personagem atacante como parâmetro. Caso a vida do alvo seja igual a zero, o método deve imprimir uma mensagem informando que o ataque falhou;
 */

public class Personagem {
    public String nome;
    public Integer vida = 100;

    public void receberDano(Integer dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println("Inimigo derrotado!");
        }
    }

    public void atacar(Personagem alvo) {
        System.out.println(alvo.nome + " foi atacado pelo " + this.nome);
        receberDano(10); // Valor padronizado.
    }
}
