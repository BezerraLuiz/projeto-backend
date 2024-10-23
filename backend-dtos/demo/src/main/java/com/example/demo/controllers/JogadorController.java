package com.example.demo.controllers;

import com.example.demo.dtos.JogadorRequestDto;
import com.example.demo.dtos.JogadorResponseDto;
import com.example.demo.models.JogadorModel;
import com.example.demo.services.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogadorController {
    @Autowired
    JogadorService jogadorService;

    @PostMapping("/jogadores")
    public JogadorResponseDto insereJogador(@RequestBody @Valid JogadorRequestDto jogadorRequestDto) {
        return jogadorService.insereJogador(jogadorRequestDto);
    }
}
