package com.LiteTravel.web.Model;

public class HotelManager {
    private Integer hotelManagerId;

    private String hotelManagerName;

    private String hotelManagerPhone;

    private Integer hotelId;

    public Integer getHotelManagerId() {
        return hotelManagerId;
    }

    public void setHotelManagerId(Integer hotelManagerId) {
        this.hotelManagerId = hotelManagerId;
    }

    public String getHotelManagerName() {
        return hotelManagerName;
    }

    public void setHotelManagerName(String hotelManagerName) {
        this.hotelManagerName = hotelManagerName == null ? null : hotelManagerName.trim();
    }

    public String getHotelManagerPhone() {
        return hotelManagerPhone;
    }

    public void setHotelManagerPhone(String hotelManagerPhone) {
        this.hotelManagerPhone = hotelManagerPhone == null ? null : hotelManagerPhone.trim();
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
}