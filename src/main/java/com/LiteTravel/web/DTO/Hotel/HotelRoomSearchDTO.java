package com.LiteTravel.web.DTO.Hotel;

import lombok.Data;

import java.util.Date;

/**
 * @author KrisHugo
 */
@Data
public class HotelRoomSearchDTO {
    Date checkIn;
    Date checkOut;

    public HotelRoomSearchDTO() {
        checkIn = new Date();
        checkOut = new Date(checkIn.getTime() + 60 * 60 * 24 * 1000);
    }
}
