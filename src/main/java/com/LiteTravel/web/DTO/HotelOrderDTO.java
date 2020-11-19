package com.LiteTravel.web.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class HotelOrderDTO {
    private Integer hotelId;
    private Integer roomId;
    private Integer userId;
    private Date checkIn;
    private Date checkOut;
    private Integer days;
    private Integer travelers;
    private Integer children;
    private float price;

    @Override
    public String toString() {
        return "HotelOrderDTO{" +
                "hotelId=" + hotelId +
                ", roomId=" + roomId +
                ", userId=" + userId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", days=" + days +
                ", travelers=" + travelers +
                ", children=" + children +
                ", price=" + price +
                '}';
    }
}
