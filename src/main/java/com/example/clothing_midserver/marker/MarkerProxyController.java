package com.example.clothing_midserver.marker;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proxy")
public class MarkerProxyController {

    private final MarkerApiService markerApiService;

    public MarkerProxyController(MarkerApiService markerApiService) {
        this.markerApiService = markerApiService;
    }

    @GetMapping("/clothing-bins")
    public ResponseEntity<?> getClothingBins(@RequestParam double lat,
                                             @RequestParam double lng,
                                             @RequestParam double radiusKm) {
        return ResponseEntity.ok(markerApiService.getBins(lat, lng, radiusKm));
    }
}