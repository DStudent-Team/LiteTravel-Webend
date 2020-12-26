package com.LiteTravel.web.DTO;

import lombok.Data;

@Data
public class AuthorityDTO {
    private Integer userId;
    private Integer authorityLevel;
    private Boolean hotelAuthority;
    private Boolean flightAuthority;
}
