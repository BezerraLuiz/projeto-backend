package com.backend.routerairplane.services.user;

import com.backend.routerairplane.models.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<ApiResponse> verifyUser(String email, String senha);
    ResponseEntity<ApiResponse> idUser(String email);
    ResponseEntity<ApiResponse> createUser(String nome, String email, String senha);
}
