package com.LiteTravel.web.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HotelOrderSubmitDTO {
    private Integer orderId;
    private Integer hotelId;
    private String status;
    private HotelDTO hotel;
    private List<RoomDTO> rooms;
    private Integer userId;
    private Date checkIn;
    private Date checkOut;
    private Integer roomCount;
    private Integer days;
    private float price;
    private float total;

}
