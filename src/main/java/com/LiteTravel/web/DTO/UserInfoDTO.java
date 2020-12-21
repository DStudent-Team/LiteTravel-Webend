package com.LiteTravel.web.DTO;

import lombok.Data;
import java.util.Date;

@Data
public class UserInfoDTO {
    private Integer userId;
    private String userName;
    private Integer userGender;
    private Date userBirth;
    private String userPhone;
    private String userEmail;
    private String userAddressSpecific;

}
