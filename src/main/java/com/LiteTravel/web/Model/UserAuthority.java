package com.LiteTravel.web.Model;

public class UserAuthority {
    private Integer userId;

    private Integer authorityLevel;

    private Boolean hotelAuthority;

    private Boolean flightAuthority;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(Integer authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    public Boolean getHotelAuthority() {
        return hotelAuthority;
    }

    public void setHotelAuthority(Boolean hotelAuthority) {
        this.hotelAuthority = hotelAuthority;
    }

    public Boolean getFlightAuthority() {
        return flightAuthority;
    }

    public void setFlightAuthority(Boolean flightAuthority) {
        this.flightAuthority = flightAuthority;
    }
}