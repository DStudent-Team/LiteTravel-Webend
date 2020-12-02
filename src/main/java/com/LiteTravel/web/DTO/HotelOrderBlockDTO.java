package com.LiteTravel.web.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class HotelOrderBlockDTO {
    private Integer orderId;
    private Integer hotelId;
    private Integer userId;
    private String status;
    private String hotelName;
    private String hotelImgUri;
    private Date checkIn;//入店时间
    private Date checkOut;//离店时间
    private Integer days;
    private float total;
}
