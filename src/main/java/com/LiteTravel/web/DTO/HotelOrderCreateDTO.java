package com.LiteTravel.web.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class HotelOrderCreateDTO {
    private Integer orderId;
    private Integer hotelId;
    private HotelDTO hotel;
    private Integer roomId;
    private RoomDTO room;
    private Integer userId;
    private Date checkIn;
    private Date checkOut;
    private Integer travelers;
    private Integer children;
    private Integer days;
    private float price;
    private float total;

}
