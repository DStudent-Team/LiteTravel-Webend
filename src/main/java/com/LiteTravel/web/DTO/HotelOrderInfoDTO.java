package com.LiteTravel.web.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HotelOrderInfoDTO {
    private Integer orderId;
    private Integer hotelId;
    private String status;
    private HotelDTO hotel;
    private List<HotelOrderDetailDTO> rooms;
    private Integer userId;
    private Date checkIn;
    private Date checkOut;
    private Integer days;
    private float price;
    private float total;
}
