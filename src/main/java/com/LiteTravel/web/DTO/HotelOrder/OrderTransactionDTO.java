package com.LiteTravel.web.DTO.HotelOrder;

import lombok.Data;

/**
 * @Author xiaobai
 * @Date 2020/12/26 23:25
 * @Version 1.0
 */
@Data
public class OrderTransactionDTO {
    private Integer orderId;
    private Integer userId;
    private Integer hotelId;
    private Float money;
    private String userPassword;
}
