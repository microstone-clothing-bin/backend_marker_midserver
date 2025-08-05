package com.example.clothing_midserver.marker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mid")
@CrossOrigin(origins = "*") // 프론트 연동을 위한 선물
public class MarkerController {

    private final MarkerService markerService;

    @Autowired
    public MarkerController(MarkerService markerService) {
        this.markerService = markerService;
    }

    @GetMapping("/bins")
    public List<ClothingBin> getBins() {
        return markerService.getAllBins();
    }
}