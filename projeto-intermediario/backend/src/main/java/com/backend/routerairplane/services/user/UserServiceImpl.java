package com.backend.routerairplane.services.user;

import com.backend.routerairplane.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.*;

@Service
public class UserServiceImpl implements UserService {

    private final String urldb = "jdbc:postgresql://ep-sparkling-resonance-a53cswmu.us-east-2.aws.neon.tech/router-airplane";
    private final String userdb = "bytezest";
    private final String passworddb = "MX8VGgRI1tUB";

    // querys
    private final String select_user_email = "select id, nome, email, senha from users u where u.email = ?";
    private final String select_user_id = "select id, nome, email, senha from users u where u.id = ?";
    private final String insert_user = "insert into users (nome, email, senha) values (?, ?, ?)";
    private final String update_user = "update users u set nome = ?, email = ?, senha = ? where u.email = ?";

    @Override
    public ResponseEntity<ApiResponse> verifyUser(String email, String senha) {
        String emaildb = null;
        String senhadb = null;

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            PreparedStatement ps = connection.prepareStatement(select_user_email);
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
    public ResponseEntity<ApiResponse> viewUserByEmail(String email) {
        String iddb = null;
        String emaildb = null;
        String nomedb = null;
        String senhadb = null;

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            PreparedStatement ps = connection.prepareStatement(select_user_email);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                iddb = rs.getString("id");
                nomedb = rs.getString("nome");
                emaildb = rs.getString("email");
                senhadb = rs.getString("senha");
            }

            if (!email.equals(emaildb)) return new ResponseEntity<>(new ApiResponse("Usuário não encontrado!", false), HttpStatus.NOT_FOUND);
        } catch (SQLException e) {
            return new ResponseEntity<>(new ApiResponse("Usuário não encontrado!", false), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new ApiResponse(iddb + " | " + nomedb + " | " + emaildb + " | " + senhadb, true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> viewUserById(Long id) {
        Long iddb = null;
        String emaildb = null;
        String nomedb = null;
        String senhadb = null;

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            PreparedStatement ps = connection.prepareStatement(select_user_id);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                iddb = rs.getLong("id");
                nomedb = rs.getString("nome");
                emaildb = rs.getString("email");
                senhadb = rs.getString("senha");
            }

            if (!id.equals(iddb)) return new ResponseEntity<>(new ApiResponse("Usuário não encontrado!", false), HttpStatus.NOT_FOUND);
        } catch (SQLException e) {
            return new ResponseEntity<>(new ApiResponse("Usuário não encontrado!", false), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new ApiResponse(iddb + " | " + nomedb + " | " + emaildb + " | " + senhadb, true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> createUser(String nome, String email, String senha) {
        String emaildb = null;

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            PreparedStatement psSelect = connection.prepareStatement(insert_user);
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

    @Override
    public ResponseEntity<ApiResponse> updateUser(String nome, String email, String senha) {

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            PreparedStatement ps = connection.prepareStatement(update_user);

            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, senha);
            ps.setString(4, email);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                return new ResponseEntity<>(new ApiResponse("Usuário atualizado com sucesso!", true), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ApiResponse("Erro ao criar usuário!", false), HttpStatus.BAD_REQUEST);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(new ApiResponse("Erro na atualização do usuário!", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
