package com.backend.routerairplane.services.travel;

import com.backend.routerairplane.models.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface TravelService {
    ResponseEntity<ApiResponse> createTravel(Long idUser, String localViagem, String localHospedagem, LocalDate dataInicio, LocalDate dataFim, Number valorPassagem,
                                             Number valorHospedagem, Number valorConsumo, Number valorTotal  );
}
