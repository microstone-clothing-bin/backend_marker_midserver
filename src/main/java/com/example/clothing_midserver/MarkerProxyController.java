package com.example.clothing_midserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkerProxyController {

    @Autowired
    private MarkerApiService markerApiService;

    @GetMapping("/proxy/markers")
    public String proxyMarkers() {
        return markerApiService.getMarkers();
    }
}