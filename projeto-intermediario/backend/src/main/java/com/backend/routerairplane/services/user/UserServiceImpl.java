package com.backend.routerairplane.services.user;

import com.backend.routerairplane.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class UserServiceImpl implements UserService {

    private final String urldb = "jdbc:postgresql://ep-sparkling-resonance-a53cswmu.us-east-2.aws.neon.tech/router-airplane";
    private final String userdb = "bytezest";
    private final String passworddb = "MX8VGgRI1tUB";

    // querys
    private final String select_user = "select id, nome, email, senha from users u where u.email = ?";
    private final String select_user_id = "select id, email from users u where u.email = ?";
    private final String insert_user = "insert into users (nome, email, senha) values (?, ?, ?)";

    @Override
    public ResponseEntity<ApiResponse> verifyUser(String email, String senha) {
        String emaildb = null;
        String senhadb = null;

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            PreparedStatement ps = connection.prepareStatement(select_user);
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

    @Override
    public ResponseEntity<ApiResponse> idUser(String email) {
        String id = null;
        String emaildb = null;

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            PreparedStatement ps = connection.prepareStatement(select_user_id);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getString("id");
                emaildb = rs.getString("email");
            }

            if (!email.equals(emaildb)) return new ResponseEntity<>(new ApiResponse("Usuário não encontrado!", false), HttpStatus.NOT_FOUND);
        } catch (SQLException e) {
            return new ResponseEntity<>(new ApiResponse("Usuário não encontrado!", false), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new ApiResponse(id, true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> createUser(String nome, String email, String senha) {
        String emaildb = null;

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            PreparedStatement psSelect = connection.prepareStatement(select_user_id);
            psSelect.setString(1, email);

            ResultSet rs = psSelect.executeQuery();

            while (rs.next()) {
                emaildb = rs.getString("email");
            }

            if (email.equals(emaildb)) {
                return new ResponseEntity<>(new ApiResponse("Usuário já cadastrado!", false), HttpStatus.UNAUTHORIZED);
            } else {
                try {
                    PreparedStatement psInsert = connection.prepareStatement(insert_user);

                    psInsert.setString(1, nome);
                    psInsert.setString(2, email.toLowerCase());
                    psInsert.setString(3, senha);

                    int rowsAffected = psInsert.executeUpdate();

                    if (rowsAffected > 0) {
                        return new ResponseEntity<>(new ApiResponse("Usuário Criado!", true), HttpStatus.CREATED);
                    } else {
                        return new ResponseEntity<>(new ApiResponse("Erro ao criar usuário!", false), HttpStatus.BAD_REQUEST);
                    }
                } catch (SQLException e) {
                    return new ResponseEntity<>(new ApiResponse("Não foi possível criar o usuário! " + e.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(new ApiResponse("Erro na verificação de usuário existente!", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
