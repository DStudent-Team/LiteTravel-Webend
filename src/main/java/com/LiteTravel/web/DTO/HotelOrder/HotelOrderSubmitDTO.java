package com.LiteTravel.web.DTO.HotelOrder;

import lombok.Data;

@Data
public class HotelOrderSubmitDTO {
    Integer hotelId;
    Integer roomId;
    Integer userId;
    String checkIn;
    String checkOut;
    Integer roomCount;
    float price;
}
