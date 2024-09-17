package com.backend.routerairplane.services.user;

import com.backend.routerairplane.models.ApiResponse;
import com.backend.routerairplane.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.*;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final String urldb = "jdbc:postgresql://ep-sparkling-resonance-a53cswmu.us-east-2.aws.neon.tech/router-airplane";
    private final String userdb = "bytezest";
    private final String passworddb = "MX8VGgRI1tUB";
    private final String select_user_sql = "select id, nome, email, senha from users u where u.email = ?";

    @Override
    public ResponseEntity<ApiResponse> verifyUser(String email, String senha) {
        String emaildb = null;
        String senhadb = null;

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            PreparedStatement ps = connection.prepareStatement(select_user_sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                emaildb = rs.getString("email");
                senhadb = rs.getString("senha");
            }

            if (!email.equals(emaildb) || !senha.equals(senhadb)) {
                return new ResponseEntity<>(new ApiResponse("Credenciais Incorretas!", false), HttpStatus.UNAUTHORIZED);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(new ApiResponse("Erro ao tentar buscar o usuário!", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new ApiResponse("Usuário Logado!", true), HttpStatus.OK);
    }
}
