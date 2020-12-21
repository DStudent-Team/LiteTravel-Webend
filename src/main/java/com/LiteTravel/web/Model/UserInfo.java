package com.LiteTravel.web.Model;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private String userName;

    private Integer userGender;

    private Date userBirth;

    private String userPhone;

    private String userEmail;

    private Integer userAddress;

    private String userAddressSpecific;

    private String userAvatarUri;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Integer userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAddressSpecific() {
        return userAddressSpecific;
    }

    public void setUserAddressSpecific(String userAddressSpecific) {
        this.userAddressSpecific = userAddressSpecific == null ? null : userAddressSpecific.trim();
    }

    public String getUserAvatarUri() {
        return userAvatarUri;
    }

    public void setUserAvatarUri(String userAvatarUri) {
        this.userAvatarUri = userAvatarUri == null ? null : userAvatarUri.trim();
    }
}