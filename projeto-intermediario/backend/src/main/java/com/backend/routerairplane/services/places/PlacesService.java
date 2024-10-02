package com.backend.routerairplane.services.places;

import com.backend.routerairplane.models.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PlacesService {
    ResponseEntity<ApiResponse> viewPlace(String local);
}
