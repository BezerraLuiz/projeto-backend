package com.projetointermediario.routerairplane.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/travels")
public class TravelController {
    @PostMapping("/create")
    public String createTravel(@RequestParam String place, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return place + date;
    }

    @GetMapping("/view")
    public String viewTravels() {
        return "Viagem";
    }
}
