package com.backend.routerairplane.services.places;

import com.backend.routerairplane.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlacesServiceImpl implements PlacesService {
    private final String api_key = "AIzaSyBGdOdZFKEi9rac-WGfGKwgkkjguVktcmk";
    private final String geocode_url = "https://maps.googleapis.com/maps/api/geocode/json";

    @Override
    public ResponseEntity<ApiResponse> viewPlace(String local) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromHttpUrl(geocode_url)
                .queryParam("address", local)
                .queryParam("key", api_key)
                .toUriString();

        Map<String, Object> response = restTemplate.getForObject(url, HashMap.class);

        if (response != null && "OK".equals(response.get("status"))) {
            List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

            if (!results.isEmpty()) {
                Map<String, Object> geometry = (Map<String, Object>) results.get(0).get("geometry");
                Map<String, Object> location = (Map<String, Object>) geometry.get("location");

                return new ResponseEntity<>(new ApiResponse("Localização obtida com sucesso: " + location, true), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(new ApiResponse("Falha ao obter a localização da API do Google Maps", false), HttpStatus.BAD_REQUEST);
    }
}
