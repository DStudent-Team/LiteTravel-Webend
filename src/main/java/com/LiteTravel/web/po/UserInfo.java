package com.LiteTravel.web.po;

public class UserInfo {
    public Integer user_id;
    public String username;
    public Integer sex;
    public String phone;
    public String city;
    public String email;
    public String user_avatarUrl;

    @Override
    public String toString() {
        return "UserInfo{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", user_avatarUrl='" + user_avatarUrl + '\'' +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_avatarUrl() {
        return user_avatarUrl;
    }

    public void setUser_avatarUrl(String user_avatarUrl) {
        this.user_avatarUrl = user_avatarUrl;
    }
}
