package com.example.exemplo_semana06.controllers;

import com.example.exemplo_semana06.services.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {
    @Autowired
    private ExercicioService exercicioService;

    @GetMapping("/recomenda")
    public String recomenda(
            @RequestParam String ambientacao,
            @RequestParam String genero
    ) {
        return exercicioService.recomendaFilme(ambientacao, genero);
    }
}
