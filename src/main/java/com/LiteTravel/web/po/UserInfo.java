/*
* 用户个人信息Po
* 用于保存用户的基本个人信息
* todo 用户地址信息仍需要跟进修缮
* */
package com.LiteTravel.web.po;

import java.util.Date;

public class UserInfo {
    public Integer userId;
    public String userName;
    public Integer userGender;
    public String userPhone;
    public String userAddress;
    public String userEmail;
    public Date userBirth;
    public String userAvatarUri;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userGender=" + userGender +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirth=" + userBirth +
                ", userAvatarUri='" + userAvatarUri + '\'' +
                '}';
    }

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
        this.userName = userName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserAvatarUri() {
        return userAvatarUri;
    }

    public void setUserAvatarUri(String userAvatarUri) {
        this.userAvatarUri = userAvatarUri;
    }
}
