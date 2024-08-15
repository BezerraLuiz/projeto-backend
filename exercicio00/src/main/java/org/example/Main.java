package org.example;

import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        String[] vetorCores = {
                "azul",
                "vermelho",
                "amarelo",
                "marrom",
                "verde"
        };

        while (true) {
            // Exercício 1.
            // Gerar nome de usuário recebendo nome e sobrenome.
            // E adicionar um número aleatório.

            Scanner leitor = new Scanner(System.in);
            System.out.println("Digite seu primeiro nome: ");
            String name = leitor.nextLine();

            if (name.isEmpty()) break; //break para sair do while.
            // Poderia ser usado o return.
            // Ou o continue, caso houvesse uma outra iteração além do while.

            System.out.println("Digite seu sobrenome: ");
            String lastName = leitor.nextLine();

            Random randomNumber = new Random();

            String cor = vetorCores[randomNumber.nextInt(vetorCores.length)];

            // nextInt(origin, bound).
            // origin = menor número, bound = maior número.
            System.out.println(name + lastName + randomNumber.nextInt(10, 100) + cor);
            // Valor bound será sempre -1, neste caso o maior será 99.
            break;
        }
    }
}