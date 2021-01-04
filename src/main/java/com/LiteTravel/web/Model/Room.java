package com.LiteTravel.web.Model;

public class Room {
    private Integer roomId;

    private Integer hotelId;

    private String roomName;

    private Float roomPrice;

    private Integer roomMax;

    private Integer roomBookMax;

    private Integer roomCancel;

    private Integer roomSize;

    private String roomWifi;

    private Float roomBedAdd;

    private String roomDescription;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Integer getRoomMax() {
        return roomMax;
    }

    public void setRoomMax(Integer roomMax) {
        this.roomMax = roomMax;
    }

    public Integer getRoomBookMax() {
        return roomBookMax;
    }

    public void setRoomBookMax(Integer roomBookMax) {
        this.roomBookMax = roomBookMax;
    }

    public Integer getRoomCancel() {
        return roomCancel;
    }

    public void setRoomCancel(Integer roomCancel) {
        this.roomCancel = roomCancel;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomWifi() {
        return roomWifi;
    }

    public void setRoomWifi(String roomWifi) {
        this.roomWifi = roomWifi == null ? null : roomWifi.trim();
    }

    public Float getRoomBedAdd() {
        return roomBedAdd;
    }

    public void setRoomBedAdd(Float roomBedAdd) {
        this.roomBedAdd = roomBedAdd;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription == null ? null : roomDescription.trim();
    }
}