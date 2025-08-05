package com.example.clothing_midserver.marker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MarkerService {

    private final RestTemplate restTemplate;

    // Render에 배포된 Marker 서버 URL
    private final String markerServerUrl = "https://marker-url.onrender.com/api/clothing-bins";

    @Autowired
    public MarkerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ClothingBin> getAllBins() {
        ClothingBin[] bins = restTemplate.getForObject(markerServerUrl, ClothingBin[].class);
        return Arrays.asList(bins);
    }
}