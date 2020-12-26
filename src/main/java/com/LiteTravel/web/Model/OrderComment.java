package com.LiteTravel.web.Model;

public class OrderComment {
    private Integer ocId;

    private String userName;

    private Integer hotelId;

    private Integer orderId;

    private Integer ocScore;

    private String ocDetail;

    public Integer getOcId() {
        return ocId;
    }

    public void setOcId(Integer ocId) {
        this.ocId = ocId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOcScore() {
        return ocScore;
    }

    public void setOcScore(Integer ocScore) {
        this.ocScore = ocScore;
    }

    public String getOcDetail() {
        return ocDetail;
    }

    public void setOcDetail(String ocDetail) {
        this.ocDetail = ocDetail == null ? null : ocDetail.trim();
    }
}