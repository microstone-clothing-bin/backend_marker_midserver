package com.example.clothing_midserver.marker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.cache.annotation.Cacheable;  // 캐싱 설정

import java.util.Arrays;
import java.util.List;

@Service
public class MarkerApiService {

    private final RestTemplate restTemplate;

    public MarkerApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "clothingBins", key = "#lat + '-' + #lng + '-' + #radiusKm")
    public List<ClothingBin> getBins(double lat, double lng, double radiusKm) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/clothing-bins")
                .queryParam("lat", lat)
                .queryParam("lng", lng)
                .queryParam("radiusKm", radiusKm)
                .toUriString();

        ClothingBin[] bins = restTemplate.getForObject(url, ClothingBin[].class);
        return Arrays.asList(bins);
    }
}