package org.cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Filme> filmesDisponiveis = new ArrayList<>();
    private List<Ingresso> ingressosVendidos = new ArrayList<>();

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public List<Filme> getFilmesDisponiveis() {
        return filmesDisponiveis;
    }

    public void venderIngresso(Ingresso ingresso) {
        ingressosVendidos.add(ingresso);
    }

    public boolean assentoDisponivel(String assento) {
        for (Ingresso ingresso : ingressosVendidos) {
            if (ingresso.getAssento().equals(assento)) {
                return false;
            }
        }
        return true;
    }

    public Filme buscarFilme(String nomeFilme) {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                return filme;
            }
        }
        return null;
    }
}

