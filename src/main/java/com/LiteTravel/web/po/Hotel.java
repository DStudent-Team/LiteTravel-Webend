/*
* 酒店概览信息表
* 用于酒店的列表展示, 地址信息仍需要做些许修改
* */
package com.LiteTravel.web.po;

public class Hotel {
    public Integer hotelId;
    public String hotelName;
    public Integer hotelMinPrice;
    public String hotelDesc;
    public String hotelTel;
    public String hotelAddress;
    public String hotelImgUri;

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelMinPrice=" + hotelMinPrice +
                ", hotelDesc='" + hotelDesc + '\'' +
                ", hotelTel='" + hotelTel + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelImgUri='" + hotelImgUri + '\'' +
                '}';
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getHotelMinPrice() {
        return hotelMinPrice;
    }

    public void setHotelMinPrice(Integer hotelMinPrice) {
        this.hotelMinPrice = hotelMinPrice;
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc;
    }

    public String getHotelTel() {
        return hotelTel;
    }

    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelImgUri() {
        return hotelImgUri;
    }

    public void setHotelImgUri(String hotelImgUri) {
        this.hotelImgUri = hotelImgUri;
    }
}
