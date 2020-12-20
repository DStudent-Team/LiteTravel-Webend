package com.LiteTravel.web.DTO;

import lombok.Data;

@Data
public class UserDTO {
    public Integer userId;
    public String userName;
    public String userAvatarUri;
    public Boolean userAuthority;
    public Boolean hotelAuthority;
    public Boolean flightAuthority;
    public Boolean guideAuthority;
}
