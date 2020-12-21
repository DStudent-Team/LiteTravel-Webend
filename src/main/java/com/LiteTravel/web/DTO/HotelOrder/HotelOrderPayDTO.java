package com.LiteTravel.web.DTO.HotelOrder;

import lombok.Data;

@Data
public class HotelOrderPayDTO {
    private Integer orderId;
    private String name;
    private String phone;
    private String arrived;
    private String note;
}
