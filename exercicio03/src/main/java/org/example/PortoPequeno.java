package org.example;

public class PortoPequeno extends BasePorto{
    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.tamanho <= 10) {
            barcosAtracados.add(barco);
            System.out.println("Barco atracado no porto pequeno!");
            return true;
        }
        return false;
    }
}
