package com.example.spring_semana05;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String HelloWorld(String nome) { // /?nome=String
        return "Hello World " + nome;
    }
}
