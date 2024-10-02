package com.backend.routerairplane.controllers;

import com.backend.routerairplane.models.ApiResponse;
import com.backend.routerairplane.models.Travel;
import com.backend.routerairplane.models.User;
import com.backend.routerairplane.services.travel.TravelService;
import com.backend.routerairplane.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> travelCreate(@RequestBody Travel travel) {
        // Extrair os dados da viagem
        Long idUser = travel.getIdUser();
        String localViagem = travel.getLocalViagem();
        String localHospedagem = travel.getLocalHospedagem();
        LocalDate dataInicio = travel.getDataInicio();
        LocalDate dataFim = travel.getDataFim();
        BigDecimal valorPassagem = travel.getValorPassagem();
        BigDecimal valorHospedagem = travel.getValorHospedagem();
        BigDecimal valorConsumo = travel.getValorConsumo();
        BigDecimal valorTotal = travel.getValorTotal();


        return travelService.createTravel(idUser, localViagem, localHospedagem, dataInicio, dataFim, valorPassagem, valorHospedagem, valorConsumo, valorTotal);
    }
}
