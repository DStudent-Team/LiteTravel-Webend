package com.LiteTravel.web.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class UserManageDTO {
    private Integer userId;
    private String userCode;
    private String userPassword;
    private String userName;
    private Integer userGender;
    private Date userBirth;
    private String userPhone;
    private String userEmail;
    private String userAddressSpecific;
    private Integer userState;
    private Integer authorityLevel;
}
