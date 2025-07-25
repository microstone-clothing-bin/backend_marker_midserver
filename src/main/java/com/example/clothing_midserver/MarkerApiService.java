package com.example.clothing_midserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarkerApiService {

    @Autowired
    private RestTemplate restTemplate;

    private final String markerServerUrl = "http://localhost:8081/api/clothing-bins";

    public String getMarkers() {
        // 단순히 JSON 문자열 받아오기 (필요 시 DTO로 매핑 가능)
        return restTemplate.getForObject(markerServerUrl, String.class);
    }
}