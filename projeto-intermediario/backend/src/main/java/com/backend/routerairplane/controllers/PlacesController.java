package com.backend.routerairplane.controllers;

import com.backend.routerairplane.models.ApiResponse;
import com.backend.routerairplane.services.places.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps")
public class PlacesController {

    @Autowired
    private PlacesService placesService;

    @GetMapping("/place")
    public ResponseEntity<ApiResponse> places(@RequestParam String local) {
        return placesService.viewPlace(local);
    }
}
