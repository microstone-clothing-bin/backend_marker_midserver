package com.example.clothing_midserver.marker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarkerProxyController {

    private final MarkerApiService markerApiService;

    public MarkerProxyController(MarkerApiService markerApiService) {
        this.markerApiService = markerApiService;
    }

    @GetMapping("/proxy/clothing-bins")
    public List<ClothingBin> getClothingBins(@RequestParam double lat,
                                             @RequestParam double lng,
                                             @RequestParam double radiusKm) {
        return markerApiService.getBins(lat, lng, radiusKm);
    }
}