package com.example.exemplo_semana06.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExercicioService {
    public String recomendaFilme(String ambientacao, String genero) {
        String filmeRecomendado = "";

        if (ambientacao.equalsIgnoreCase("medieval") && genero.equalsIgnoreCase("comedia")) {
            return "Shrek";
        }


        return filmeRecomendado;
    }
}
