package com.LiteTravel.web.Model;

import java.util.Date;

public class HotelOrder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.order_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.hotel_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Integer hotelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.user_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.user_phone
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private String userPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.user_name
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.when_arrived
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private String whenArrived;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.days
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Integer days;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.status
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.check_in
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Date checkIn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.check_out
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Date checkOut;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.create_date
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.pay_date
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Date payDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.confirm_check_in
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Date confirmCheckIn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.confirm_check_out
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Date confirmCheckOut;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.total
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Float total;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders.note
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.order_id
     *
     * @return the value of travel_hotel_orders.order_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.order_id
     *
     * @param orderId the value for travel_hotel_orders.order_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.hotel_id
     *
     * @return the value of travel_hotel_orders.hotel_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Integer getHotelId() {
        return hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.hotel_id
     *
     * @param hotelId the value for travel_hotel_orders.hotel_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.user_id
     *
     * @return the value of travel_hotel_orders.user_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.user_id
     *
     * @param userId the value for travel_hotel_orders.user_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.user_phone
     *
     * @return the value of travel_hotel_orders.user_phone
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.user_phone
     *
     * @param userPhone the value for travel_hotel_orders.user_phone
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.user_name
     *
     * @return the value of travel_hotel_orders.user_name
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.user_name
     *
     * @param userName the value for travel_hotel_orders.user_name
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.when_arrived
     *
     * @return the value of travel_hotel_orders.when_arrived
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public String getWhenArrived() {
        return whenArrived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.when_arrived
     *
     * @param whenArrived the value for travel_hotel_orders.when_arrived
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setWhenArrived(String whenArrived) {
        this.whenArrived = whenArrived == null ? null : whenArrived.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.days
     *
     * @return the value of travel_hotel_orders.days
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Integer getDays() {
        return days;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.days
     *
     * @param days the value for travel_hotel_orders.days
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.status
     *
     * @return the value of travel_hotel_orders.status
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.status
     *
     * @param status the value for travel_hotel_orders.status
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.check_in
     *
     * @return the value of travel_hotel_orders.check_in
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.check_in
     *
     * @param checkIn the value for travel_hotel_orders.check_in
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.check_out
     *
     * @return the value of travel_hotel_orders.check_out
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.check_out
     *
     * @param checkOut the value for travel_hotel_orders.check_out
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.create_date
     *
     * @return the value of travel_hotel_orders.create_date
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.create_date
     *
     * @param createDate the value for travel_hotel_orders.create_date
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.pay_date
     *
     * @return the value of travel_hotel_orders.pay_date
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.pay_date
     *
     * @param payDate the value for travel_hotel_orders.pay_date
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.confirm_check_in
     *
     * @return the value of travel_hotel_orders.confirm_check_in
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Date getConfirmCheckIn() {
        return confirmCheckIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.confirm_check_in
     *
     * @param confirmCheckIn the value for travel_hotel_orders.confirm_check_in
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setConfirmCheckIn(Date confirmCheckIn) {
        this.confirmCheckIn = confirmCheckIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.confirm_check_out
     *
     * @return the value of travel_hotel_orders.confirm_check_out
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Date getConfirmCheckOut() {
        return confirmCheckOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.confirm_check_out
     *
     * @param confirmCheckOut the value for travel_hotel_orders.confirm_check_out
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setConfirmCheckOut(Date confirmCheckOut) {
        this.confirmCheckOut = confirmCheckOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.total
     *
     * @return the value of travel_hotel_orders.total
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Float getTotal() {
        return total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.total
     *
     * @param total the value for travel_hotel_orders.total
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setTotal(Float total) {
        this.total = total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders.note
     *
     * @return the value of travel_hotel_orders.note
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders.note
     *
     * @param note the value for travel_hotel_orders.note
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}