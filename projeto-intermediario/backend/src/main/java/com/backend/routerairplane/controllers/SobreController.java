package com.backend.routerairplane.controllers;

import com.backend.routerairplane.models.SobreResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sobre")
public class SobreController {

    @GetMapping
    public ResponseEntity<SobreResponse> getSobreInfo() {
        SobreResponse response = new SobreResponse("Luiz Antônio Ponciano Costa Bezerra",
                "RouterAirplane");
        return ResponseEntity.ok(response);
    }
}
