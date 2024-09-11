package com.exemplo.filme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Testar utilizando http://localhost:8080/recomendar?genero=comedia&ambiente=sci-fi

@SpringBootApplication
public class FilmeRecomendacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmeRecomendacaoApplication.class, args);
	}

}
