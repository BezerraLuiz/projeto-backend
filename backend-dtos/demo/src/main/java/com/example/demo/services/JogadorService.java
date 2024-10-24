package com.example.demo.services;

import com.example.demo.dtos.JogadorRequestDto;
import com.example.demo.dtos.JogadorResponseDto;
import com.example.demo.mapper.JogadorMapper;
import com.example.demo.models.JogadorModel;
import com.example.demo.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JogadorService {
    List<JogadorModel> jogadores = new ArrayList<>();
    @Autowired
    JogadorMapper jogadorMapper;

    @Autowired
    JogadorRepository jogadorRepository;

    public JogadorResponseDto insereJogador(JogadorRequestDto jogadorRequestDto) {
        JogadorModel jogador = new JogadorModel();

        Integer habilidadeInicial = new Random().nextInt(0, 100);

        jogador.setNome(jogadorRequestDto.nome());
        jogador.setNick(jogadorRequestDto.nick());
        jogador.setIdade(jogadorRequestDto.idade());
        jogador.setHabilidade(habilidadeInicial);

        // Salvar jogador no banco de dados
        jogadores.add(jogador);

        // Criar response
        return jogadorMapper.toDto(jogador);
    }
}
