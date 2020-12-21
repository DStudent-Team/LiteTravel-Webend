package com.LiteTravel.web.DTO.HotelOrder;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class HotelOrderConfirmDTO {
    private Integer orderId;
    private Integer hotelId;
    private List<HotelOrderDetailDTO> rooms;
    private Integer userId;
    private Date checkIn;
    private Date checkOut;
    private Integer days;
    private float total;
}
