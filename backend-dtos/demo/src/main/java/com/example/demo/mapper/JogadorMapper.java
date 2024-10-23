package com.example.demo.mapper;

import com.example.demo.dtos.JogadorResponseDto;
import com.example.demo.models.JogadorModel;
import com.example.demo.services.JogadorService;
import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {
    public JogadorResponseDto toDto(JogadorModel jogador) {
        return new JogadorResponseDto(
                jogador.getNick(),
                jogador.getHabilidade()
        );
    }
}
