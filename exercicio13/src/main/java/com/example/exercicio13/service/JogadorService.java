package com.example.exercicio13.service;

import com.example.exercicio13.model.Jogador;
import com.example.exercicio13.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador salvarJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarJogadores() {
        return jogadorRepository.findAll();
    }
}
