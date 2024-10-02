package com.backend.routerairplane.services.user;

import com.backend.routerairplane.models.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UserService {
    ResponseEntity<ApiResponse> verifyUser(String email, String senha);
    ResponseEntity<ApiResponse> viewUserByEmail(String email);
    ResponseEntity<ApiResponse> viewUserById(Long id);
    ResponseEntity<ApiResponse> createUser(String nome, String email, String senha);
    ResponseEntity<ApiResponse> updateUser(String nome, String email, String senha);
}
