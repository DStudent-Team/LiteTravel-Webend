package com.LiteTravel.web.DTO;

import lombok.Data;

@Data
public class UserInfoDTO {
    private Integer userId;
    private String userName;
    private Integer userGender;
    private String userBirth;
    private Integer userPhone;
    private String userEmail;
    private String userAddressSpecific;

}
