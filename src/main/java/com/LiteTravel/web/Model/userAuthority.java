package com.LiteTravel.web.Model;

public class userAuthority {
    private Integer userId;

    private Boolean authorityLevel;

    private Boolean userAuthority;

    private Boolean hotelAuthority;

    private Boolean flightAuthority;

    private Boolean guideAuthority;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(Boolean authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    public Boolean getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(Boolean userAuthority) {
        this.userAuthority = userAuthority;
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

    public Boolean getGuideAuthority() {
        return guideAuthority;
    }

    public void setGuideAuthority(Boolean guideAuthority) {
        this.guideAuthority = guideAuthority;
    }
}