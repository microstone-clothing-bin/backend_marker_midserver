package com.example.clothing_midserver.marker;

public class ClothingBin {
    private Long id;
    private String roadAddress;
    private String landLotAddress;
    private double latitude;
    private double longitude;

    // 기본 생성자
    public ClothingBin() {}

    // getter, setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoadAddress() { return roadAddress; }
    public void setRoadAddress(String roadAddress) { this.roadAddress = roadAddress; }

    public String getLandLotAddress() { return landLotAddress; }
    public void setLandLotAddress(String landLotAddress) { this.landLotAddress = landLotAddress; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}