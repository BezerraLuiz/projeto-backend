package com.backend.routerairplane.controllers;

import com.backend.routerairplane.models.ApiResponse;
import com.backend.routerairplane.models.User;
import com.backend.routerairplane.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*") // permitindo acesso do front ao back
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/verify")
    public ResponseEntity<ApiResponse> userVerify(@RequestBody User user) {
        String email = user.getEmail();
        String senha = user.getSenha();

        return userService.verifyUser(email, senha);
    }

    @GetMapping("/id")
    public ResponseEntity<ApiResponse> userId(@RequestParam String email) {
        return userService.idUser(email);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> userCreate(@RequestBody User user) {
        String nome = user.getNome();
        String email = user.getEmail();
        String senha = user.getSenha();

        return userService.createUser(nome, email, senha);
    }
}
