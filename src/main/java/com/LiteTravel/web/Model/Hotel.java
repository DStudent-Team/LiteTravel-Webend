package com.LiteTravel.web.Model;

public class Hotel {
    private Integer hotelId;

    private String hotelName;

    private Integer hotelMinPrice;

    private Integer hotelManagerId;

    private String hotelPhone;

    private Integer hotelReplyLevel;

    private String hotelDescription;

    private Integer hotelAddress;

    private String hotelAddressSpecific;

    private String hotelImgUri;

    private Integer hotelReplyCount;

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
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public Integer getHotelMinPrice() {
        return hotelMinPrice;
    }

    public void setHotelMinPrice(Integer hotelMinPrice) {
        this.hotelMinPrice = hotelMinPrice;
    }

    public Integer getHotelManagerId() {
        return hotelManagerId;
    }

    public void setHotelManagerId(Integer hotelManagerId) {
        this.hotelManagerId = hotelManagerId;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone == null ? null : hotelPhone.trim();
    }

    public Integer getHotelReplyLevel() {
        return hotelReplyLevel;
    }

    public void setHotelReplyLevel(Integer hotelReplyLevel) {
        this.hotelReplyLevel = hotelReplyLevel;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription == null ? null : hotelDescription.trim();
    }

    public Integer getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(Integer hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelAddressSpecific() {
        return hotelAddressSpecific;
    }

    public void setHotelAddressSpecific(String hotelAddressSpecific) {
        this.hotelAddressSpecific = hotelAddressSpecific == null ? null : hotelAddressSpecific.trim();
    }

    public String getHotelImgUri() {
        return hotelImgUri;
    }

    public void setHotelImgUri(String hotelImgUri) {
        this.hotelImgUri = hotelImgUri == null ? null : hotelImgUri.trim();
    }

    public Integer getHotelReplyCount() {
        return hotelReplyCount;
    }

    public void setHotelReplyCount(Integer hotelReplyCount) {
        this.hotelReplyCount = hotelReplyCount;
    }
}