package com.LiteTravel.web.DTO;

import lombok.Data;

@Data
public class AuthorityDTO {
    private Integer userId;
    /**
     * 0: 普通用户
     * 1: 管理员
     * 2: 飞机管理员
     * 3: 酒店管理员
     * 4: 飞机+酒店管理员
     */
    private Integer authorityLevel;
    private String userName;
    private String userPhone;
    private Boolean hotelAuthority;
    private Boolean flightAuthority;
}
