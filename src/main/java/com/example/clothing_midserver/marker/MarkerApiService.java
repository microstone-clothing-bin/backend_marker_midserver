package com.example.clothing_midserver.marker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.cache.annotation.Cacheable;

import java.util.Arrays;
import java.util.List;

@Service
public class MarkerApiService {

    private final RestTemplate restTemplate; // 외부 API 호출을 위한 RestTemplate

    // 생성자 주입 방식으로 RestTemplate 주입
    public MarkerApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "clothingBins", key = "#lat + '-' + #lng + '-' + #radiusKm")
    // 캐시 적용: 같은 좌표(lat, lng)와 반경(radiusKm)으로 요청이 들어오면 결과를 캐시에서 꺼내 씀
    public List<ClothingBin> getBins(double lat, double lng, double radiusKm) {
        // 마커 서버 API URL 구성
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/clothing-bins")
                .queryParam("lat", lat) // 위도 파라미터 추가
                .queryParam("lng", lng) // 경도 파라미터 추가
                .queryParam("radiusKm", radiusKm) // 반경(km) 파라미터 추가
                .toUriString(); // 최종 URL 문자열 생성

        // 해당 URL로 GET 요청을 보내고, 응답을 ClothingBin 배열로 받음
        ClothingBin[] bins = restTemplate.getForObject(url, ClothingBin[].class);

        // 배열을 리스트로 변환해서 반환
        return Arrays.asList(bins);
    }
}
