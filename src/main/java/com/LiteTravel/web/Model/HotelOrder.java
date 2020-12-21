package com.LiteTravel.web.Model;

import java.util.Date;

public class HotelOrder {
    private Integer orderId;

    private Integer hotelId;

    private Integer userId;

    private String userPhone;

    private String userName;

    private String whenArrived;

    private Integer days;

    private String status;

    private Date checkIn;

    private Date checkOut;

    private Date createDate;

    private Date payDate;

    private Date confirmCheckIn;

    private Date confirmCheckOut;

    private Float total;

    private String note;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getWhenArrived() {
        return whenArrived;
    }

    public void setWhenArrived(String whenArrived) {
        this.whenArrived = whenArrived == null ? null : whenArrived.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getConfirmCheckIn() {
        return confirmCheckIn;
    }

    public void setConfirmCheckIn(Date confirmCheckIn) {
        this.confirmCheckIn = confirmCheckIn;
    }

    public Date getConfirmCheckOut() {
        return confirmCheckOut;
    }

    public void setConfirmCheckOut(Date confirmCheckOut) {
        this.confirmCheckOut = confirmCheckOut;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}