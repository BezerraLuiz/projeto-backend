package com.example.exemplo_semana06.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.HashMap;

@RestController
@RequestMapping("/fipe")
public class FipeController {
    // Conexao com a api
    private RestClient cliente = RestClient.create("https://parallelum.com.br");

    @GetMapping("/valor")
    @ResponseBody
    public Object valor() {
        HashMap<String, String> response = cliente
                .get()
                .uri("/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3")
                .retrieve()
                .body(HashMap.class);
        return response.get("Valor");
    }
}
