package com.LiteTravel.web.Model;

public class HotelOrderDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders_detail.order_id
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders_detail.room_id
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    private Integer roomId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders_detail.room_count
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    private Integer roomCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_hotel_orders_detail.room_price
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    private Float roomPrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders_detail.order_id
     *
     * @return the value of travel_hotel_orders_detail.order_id
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders_detail.order_id
     *
     * @param orderId the value for travel_hotel_orders_detail.order_id
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders_detail.room_id
     *
     * @return the value of travel_hotel_orders_detail.room_id
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders_detail.room_id
     *
     * @param roomId the value for travel_hotel_orders_detail.room_id
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders_detail.room_count
     *
     * @return the value of travel_hotel_orders_detail.room_count
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    public Integer getRoomCount() {
        return roomCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders_detail.room_count
     *
     * @param roomCount the value for travel_hotel_orders_detail.room_count
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_hotel_orders_detail.room_price
     *
     * @return the value of travel_hotel_orders_detail.room_price
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    public Float getRoomPrice() {
        return roomPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_hotel_orders_detail.room_price
     *
     * @param roomPrice the value for travel_hotel_orders_detail.room_price
     *
     * @mbg.generated Wed Dec 02 18:08:17 CST 2020
     */
    public void setRoomPrice(Float roomPrice) {
        this.roomPrice = roomPrice;
    }
}