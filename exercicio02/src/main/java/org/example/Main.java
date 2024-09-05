package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 Crie uma classe chamada Personagem que implemente os atributos nome, vida e ataque, além de dos métodos receberDano e atacar;

 O método receberDano recebe um parâmetro do tipo int que subtrai da vida do objeto. Se o valor da vida for menor ou igual a zero,
 o método deve imprimir uma mensagem informando que o personagem foi derrotado;

 O método atacar recebe um parâmetro do tipo Personagem chamado alvo e chama o método receberDano,
 passando o ataque do personagem atacante como parâmetro. Caso a vida do alvo seja igual a zero, o método deve imprimir uma mensagem informando que o ataque falhou;

 Repita os dois últimos passos até que o jogador ou todos os inimigos tenham a vida zerada e imprima o resultado final No método main da classe principal,
 crie uma lista de Personagem chamada de inimigos e adicione pelo menos três personagens diferentes;

 Crie um Personagem chamado jogador e use o método atacar passando como parâmetro aleatoriamente um dos personagens da lista inimigos.
 O jogador não deve atacar inimigos com vida igual a 0;

 Após o ataque do jogador, crie um loop que percorre a lista de inimigos e chama o método atacar de cada um deles passando como parâmetro o jogador;
 */

public class Main {
    public static void main(String[] args) {
        Personagem jogador = new Personagem();
        jogador.nome = "Steve";
        jogador.vida = 100;

        Personagem inimigo = new Personagem();
        inimigo.nome = "Zombie";
        inimigo.vida = 50;

        Personagem creeper = new Creeper();
        creeper.nome = "Creeper";
        creeper.vida = 30;

        List<Personagem> inimigosAlvos = Arrays.asList(inimigo, creeper);

        while (true) {
          Random random = new Random();

          Integer alvo = random.nextInt(1, 2);

          jogador.atacar(inimigosAlvos.get(alvo));

          inimigosAlvos.forEach(inimigos -> inimigos.atacar(jogador));

          break;
        }

        System.out.println("Jogador: " + jogador.vida);
        System.out.println("Zombie: " + inimigo.vida);
        System.out.println("Creeper: " + creeper.vida);
    }
}