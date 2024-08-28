package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] filmes = {"Gente Grande", "Pânico", "Gladiador", "Homens de Preto"};

        System.out.println("Pergunta 1: Qual estilo você prefere?");
        System.out.println("1 - Sci-fi");
        System.out.println("2 - Distopia");

        int opcao1 = scanner.nextInt();

        System.out.println("Pergunta 2: Qual gênero você prefere?");
        System.out.println("1 - Comédia");
        System.out.println("2 - Ação");

        int opcao2 = scanner.nextInt();

        System.out.println("Filme recomendado: " + filmes[opcao2 + opcao1 - 1]);
    }
}
