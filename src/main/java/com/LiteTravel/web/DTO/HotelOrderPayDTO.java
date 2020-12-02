package com.LiteTravel.web.DTO;

import lombok.Data;

@Data
public class HotelOrderPayDTO {
    private Integer orderId;
    private String name;
    private String phone;
    private String arrived;
    private String note;
}
