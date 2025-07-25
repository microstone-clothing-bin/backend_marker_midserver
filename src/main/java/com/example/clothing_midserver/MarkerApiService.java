package com.example.clothing_midserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class MarkerApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    // 마커서버 API 기본 URL
    private static final String MARKER_API_URL = "http://localhost:8081/api/clothing-bins";

    public List<ClothingBin> getBins(double lat, double lng, double radiusKm) {
        String url = UriComponentsBuilder.fromHttpUrl(MARKER_API_URL)
                .queryParam("lat", lat)
                .queryParam("lng", lng)
                .queryParam("radiusKm", radiusKm)
                .toUriString();

        ClothingBin[] bins = restTemplate.getForObject(url, ClothingBin[].class);
        return Arrays.asList(bins);
    }
}