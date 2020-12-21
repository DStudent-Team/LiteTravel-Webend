package com.LiteTravel.web.Model;

import java.util.Date;

public class Flight {
    private Integer flightId;

    private Integer userId;

    private Integer flightLevel;

    private Integer flightFrom;

    private Integer flightTo;

    private Date flightDepart;

    private Date flightArrived;

    private Float flightTotal;

    private Integer flightSeats;

    private Integer flightStatus;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFlightLevel() {
        return flightLevel;
    }

    public void setFlightLevel(Integer flightLevel) {
        this.flightLevel = flightLevel;
    }

    public Integer getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(Integer flightFrom) {
        this.flightFrom = flightFrom;
    }

    public Integer getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(Integer flightTo) {
        this.flightTo = flightTo;
    }

    public Date getFlightDepart() {
        return flightDepart;
    }

    public void setFlightDepart(Date flightDepart) {
        this.flightDepart = flightDepart;
    }

    public Date getFlightArrived() {
        return flightArrived;
    }

    public void setFlightArrived(Date flightArrived) {
        this.flightArrived = flightArrived;
    }

    public Float getFlightTotal() {
        return flightTotal;
    }

    public void setFlightTotal(Float flightTotal) {
        this.flightTotal = flightTotal;
    }

    public Integer getFlightSeats() {
        return flightSeats;
    }

    public void setFlightSeats(Integer flightSeats) {
        this.flightSeats = flightSeats;
    }

    public Integer getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(Integer flightStatus) {
        this.flightStatus = flightStatus;
    }
}