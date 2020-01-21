package com.travelplatform.web.po;


public class User {
    private Integer userId;
    private String userCode;
    private String userPassword;
    private Integer userState;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + userId +
                ", user_code='" + userCode + '\'' +
                ", user_password='" + userPassword + '\'' +
                ", user_state=" + userState +
                '}';
    }
}
