package com.LiteTravel.web.Model;

public class FlightTicket {
    private Integer ticketId;

    private Integer reserveId;

    private Float ticketPrice;

    private String ticketSeat;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public Float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketSeat() {
        return ticketSeat;
    }

    public void setTicketSeat(String ticketSeat) {
        this.ticketSeat = ticketSeat == null ? null : ticketSeat.trim();
    }
}