package org.cinema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instanciando Cinema e adicionando filmes
        Cinema cinema = new Cinema();
        cinema.adicionarFilme(new Filme("The Batman", 12.50, 13));
        cinema.adicionarFilme(new Filme("The Joker", 10.00, 16));
        cinema.adicionarFilme(new Filme("Deadpool x Wolverine", 15.00, 10));
        cinema.adicionarFilme(new Filme("Avengers: Ultimato", 14.00, 12));
        cinema.adicionarFilme(new Filme("Avatar", 18.00, 10));

        Scanner scanner = new Scanner(System.in);
        String nomeCliente, nomeFilme, assento;
        int idadeCliente;

        while (true) {
            try {
                System.out.print("Digite o nome do cliente: ");
                nomeCliente = scanner.nextLine();

                System.out.print("Digite a idade do cliente: ");
                idadeCliente = Integer.parseInt(scanner.nextLine());

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);

                System.out.print("Digite o nome do filme: ");
                nomeFilme = scanner.nextLine();
                Filme filmeEscolhido = cinema.buscarFilme(nomeFilme);

                if (filmeEscolhido == null) {
                    System.out.println("Filme não encontrado.");
                    continue;
                }

                if (cliente.getIdade() < filmeEscolhido.getIdadeMinima()) {
                    throw new Exception("Idade do cliente não é compatível com a idade mínima do filme.");
                }

                System.out.print("Digite o assento desejado (ex: A1 a F5): ");
                assento = scanner.nextLine();

                if (!cinema.assentoDisponivel(assento)) {
                    throw new Exception("Assento já está ocupado.");
                }

                Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assento);
                cinema.venderIngresso(ingresso);

                System.out.println("Ingresso vendido com sucesso para o filme " + filmeEscolhido.getNome() + " no assento " + assento + ".");

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.print("Deseja comprar outro ingresso? (s/n): ");
            String continuar = scanner.nextLine();
            if (continuar.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }
}
