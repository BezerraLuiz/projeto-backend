package org.example;

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

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}