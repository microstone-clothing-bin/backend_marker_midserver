package com.example.clothing_midserver.marker;

public class ClothingBin { // 의류 수거함 정보를 표현하는 클래스
    private Long id; // 고유 ID (식별자)
    private String roadAddress; // 도로명 주소
    private String landLotAddress; // 지번 주소
    private double latitude; // 위도
    private double longitude; // 경도

    // 기본 생성자
    public ClothingBin() {} // 객체 생성 시 아무 값 없이 생성할 수 있게 기본 생성자 추가

    // getter, setter
    public Long getId() { return id; } // id 반환
    public void setId(Long id) { this.id = id; } // id 설정

    public String getRoadAddress() { return roadAddress; } // 도로명 주소 반환
    public void setRoadAddress(String roadAddress) { this.roadAddress = roadAddress; } // 도로명 주소 설정

    public String getLandLotAddress() { return landLotAddress; } // 지번 주소 반환
    public void setLandLotAddress(String landLotAddress) { this.landLotAddress = landLotAddress; } // 지번 주소 설정

    public double getLatitude() { return latitude; } // 위도 반환
    public void setLatitude(double latitude) { this.latitude = latitude; } // 위도 설정

    public double getLongitude() { return longitude; } // 경도 반환
    public void setLongitude(double longitude) { this.longitude = longitude; } // 경도 설정
}
