package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Barco barco1 = new Barco();
        barco1.nome = "Merry";
        barco1.tamanho = 11;

        Barco barco2 = new Barco();
        barco2.nome = "Glory";
        barco2.tamanho = 5;

        Barco barco3 = new Barco();
        barco3.nome = "SkyFall";
        barco3.tamanho = 20;

        Barco barco4 = new Barco();
        barco4.nome = "Henry";
        barco4.tamanho = 8;

        Barco barco5 = new Barco();
        barco5.nome = "Little Jimmy";
        barco5.tamanho = 10;

        List<Barco> barcos = new ArrayList<>();
        barcos.add(barco1);
        barcos.add(barco2);
        barcos.add(barco3);
        barcos.add(barco4);
        barcos.add(barco5);

        BasePorto LittleBoat = new PortoPequeno();
        BasePorto BigMemory = new PortoGrande();

        barcos.forEach((barco) -> {
            System.out.println(barco.nome);

            boolean atracado = LittleBoat.atracarBarco(barco);

            if (!atracado) {
                BigMemory.atracarBarco(barco);
            }
        });
    }
}