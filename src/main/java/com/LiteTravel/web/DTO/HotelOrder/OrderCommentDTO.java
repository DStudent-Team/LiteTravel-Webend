package com.LiteTravel.web.DTO.HotelOrder;

import lombok.Data;

/**
 * @Author xiaobai
 * @Date 2020/12/26 20:15
 * @Version 1.0
 */
@Data
public class OrderCommentDTO {
    private Integer userId;
    private Integer hotelId;
    private Integer orderId;
    private Integer score;
    private String detail;
}
