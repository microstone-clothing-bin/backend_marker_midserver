package com.example.clothing_midserver.marker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proxy")
public class MarkerProxyController {

    private final MarkerApiService markerApiService; // 마커 API 호출 서비스

    // 생성자 주입을 통해 MarkerApiService를 받아옴
    public MarkerProxyController(MarkerApiService markerApiService) {
        this.markerApiService = markerApiService;
    }

    @GetMapping("/clothing-bins") // GET 요청을 "/api/proxy/clothing-bins" 경로로 매핑
    public ResponseEntity<?> getClothingBins(@RequestParam double lat,     // 위도 파라미터
                                             @RequestParam double lng,     // 경도 파라미터
                                             @RequestParam double radiusKm) { // 반경 파라미터
        // 서비스로부터 결과 받아서 HTTP 200 OK로 응답
        return ResponseEntity.ok(markerApiService.getBins(lat, lng, radiusKm));
    }
}
