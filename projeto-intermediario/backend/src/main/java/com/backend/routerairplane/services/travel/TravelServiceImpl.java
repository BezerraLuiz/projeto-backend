package com.backend.routerairplane.services.travel;

import com.backend.routerairplane.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

@Service
public class TravelServiceImpl implements TravelService {

    private final String urldb = "jdbc:postgresql://ep-sparkling-resonance-a53cswmu.us-east-2.aws.neon.tech/router-airplane";
    private final String userdb = "bytezest";
    private final String passworddb = "MX8VGgRI1tUB";

    private final String insert_travel = "insert into travels (\n" +
            "    user_id, local_viagem, local_hospedagem, data_inicio, data_fim, \n" +
            "    valor_passagem, valor_hospedagem, valor_consumo, valor_total\n" +
            ") \n" +
            "VALUES \n" +
            "(\n" +
            "    ?,\n" +
            "    ?,\n" +
            "    ?,\n" +
            "    ?,\n" +
            "    ?,\n" +
            "    ?,\n" +
            "    ?,\n" +
            "    ?,\n" +
            "    ?)";
    String select_travel = "select * from travels where user_id = ? and local_viagem = ? and local_hospedagem = ? " +
            "and data_inicio = ? and data_fim = ? and valor_passagem = ? and valor_hospedagem = ? and valor_consumo = ?";

    @Override
    public ResponseEntity<ApiResponse> createTravel(Long idUser, String localViagem, String localHospedagem, LocalDate dataInicio, LocalDate dataFim, Number valorPassagem,
                                                    Number valorHospedagem, Number valorConsumo, Number valorTotal) {

        try (Connection connection = DriverManager.getConnection(urldb, userdb, passworddb)) {
            // Consulta para verificar se a viagem já existe com todas as informações iguais

            PreparedStatement psSelect = connection.prepareStatement(select_travel);
            psSelect.setLong(1, idUser);
            psSelect.setString(2, localViagem);
            psSelect.setString(3, localHospedagem);
            psSelect.setDate(4, Date.valueOf(dataInicio));
            psSelect.setDate(5, Date.valueOf(dataFim));
            psSelect.setBigDecimal(6, (BigDecimal) valorPassagem);
            psSelect.setBigDecimal(7, (BigDecimal) valorHospedagem);
            psSelect.setBigDecimal(8, (BigDecimal) valorConsumo);

            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                // Se já existe uma viagem com essas informações, retorna erro
                return new ResponseEntity<>(new ApiResponse("Viagem já cadastrada!", false), HttpStatus.UNAUTHORIZED);
            } else {
                try (PreparedStatement psInsert = connection.prepareStatement(insert_travel)) {
                    psInsert.setLong(1, idUser);
                    psInsert.setString(2, localViagem);
                    psInsert.setString(3, localHospedagem);
                    psInsert.setDate(4, Date.valueOf(dataInicio));
                    psInsert.setDate(5, Date.valueOf(dataFim));
                    psInsert.setBigDecimal(6, (BigDecimal) valorPassagem);
                    psInsert.setBigDecimal(7, (BigDecimal) valorHospedagem);
                    psInsert.setBigDecimal(8, (BigDecimal) valorConsumo);
                    psInsert.setBigDecimal(9, (BigDecimal) valorTotal);

                    int rowsAffected = psInsert.executeUpdate();

                    if (rowsAffected > 0) {
                        return new ResponseEntity<>(new ApiResponse("Viagem criada com sucesso!", true), HttpStatus.CREATED);
                    } else {
                        return new ResponseEntity<>(new ApiResponse("Erro ao criar viagem!", false), HttpStatus.BAD_REQUEST);
                    }
                } catch (SQLException e) {
                    return new ResponseEntity<>(new ApiResponse("Erro ao inserir viagem! " + e.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(new ApiResponse("Erro na verificação da viagem existente!", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}