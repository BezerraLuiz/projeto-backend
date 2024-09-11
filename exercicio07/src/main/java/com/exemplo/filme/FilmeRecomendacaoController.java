package com.exemplo.filme;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Testar utilizando http://localhost:8080/recomendar?genero=comedia&ambiente=sci-fi

@RestController
public class FilmeRecomendacaoController {

    @GetMapping("/recomendar")
    public String recomendarFilme(@RequestParam String genero, @RequestParam String ambiente) {
        // Definindo as recomendações com base em ambiente e gênero
        if ("sci-fi".equalsIgnoreCase(ambiente)) {
            if ("comedia".equalsIgnoreCase(genero)) {
                return "Homens de Preto";
            } else if ("drama".equalsIgnoreCase(genero)) {
                return "Arrival";
            }
        } else if ("medieval".equalsIgnoreCase(ambiente)) {
            if ("comedia".equalsIgnoreCase(genero)) {
                return "Shrek";
            } else if ("drama".equalsIgnoreCase(genero)) {
                return "Gladiador";
            }
        }
        return "Nenhuma recomendação disponível para essas opções.";
    }
}
