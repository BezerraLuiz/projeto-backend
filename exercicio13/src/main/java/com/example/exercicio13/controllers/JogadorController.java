package com.example.exercicio13.controllers;

import com.example.exercicio13.dto.JogadorDTO;
import com.example.exercicio13.mapper.JogadorMapper;
import com.example.exercicio13.model.Jogador;
import com.example.exercicio13.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private JogadorMapper jogadorMapper;

    @PostMapping
    public ResponseEntity<JogadorDTO> criarJogador(@Valid @RequestBody JogadorDTO jogadorDTO) {
        Jogador jogador = jogadorMapper.toEntity(jogadorDTO);
        jogador = jogadorService.salvarJogador(jogador);
        return ResponseEntity.ok(jogadorMapper.toDTO(jogador));
    }

    @GetMapping
    public ResponseEntity<List<JogadorDTO>> listarJogadores() {
        List<JogadorDTO> jogadores = jogadorService.listarJogadores()
                .stream()
                .map(jogadorMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(jogadores);
    }
}
