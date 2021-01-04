package com.LiteTravel.web.DTO.HotelOrder;

import lombok.Data;

/**
 * @Author xiaobai
 * @Date 2020/12/26 20:46
 * @Version 1.0
 */
@Data
public class DisplayOrderCommentDTO {

    private String username;
    private Integer score;
    private String detail;

    public DisplayOrderCommentDTO(String username, Integer score, String detail) {
        this.username = username;
        this.score = score;
        this.detail = detail;
    }
}
