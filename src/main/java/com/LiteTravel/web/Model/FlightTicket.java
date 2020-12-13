package com.LiteTravel.web.Model;

public class FlightTicket {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_flight_ticket.ticket_id
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    private Integer ticketId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_flight_ticket.flight_id
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    private Integer flightId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_flight_ticket.user_id
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_flight_ticket.ticket_price
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    private Float ticketPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_flight_ticket.ticket_seat
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    private String ticketSeat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_flight_ticket.ticket_id
     *
     * @return the value of travel_flight_ticket.ticket_id
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public Integer getTicketId() {
        return ticketId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_flight_ticket.ticket_id
     *
     * @param ticketId the value for travel_flight_ticket.ticket_id
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_flight_ticket.flight_id
     *
     * @return the value of travel_flight_ticket.flight_id
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public Integer getFlightId() {
        return flightId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_flight_ticket.flight_id
     *
     * @param flightId the value for travel_flight_ticket.flight_id
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_flight_ticket.user_id
     *
     * @return the value of travel_flight_ticket.user_id
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_flight_ticket.user_id
     *
     * @param userId the value for travel_flight_ticket.user_id
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_flight_ticket.ticket_price
     *
     * @return the value of travel_flight_ticket.ticket_price
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public Float getTicketPrice() {
        return ticketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_flight_ticket.ticket_price
     *
     * @param ticketPrice the value for travel_flight_ticket.ticket_price
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public void setTicketPrice(Float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_flight_ticket.ticket_seat
     *
     * @return the value of travel_flight_ticket.ticket_seat
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public String getTicketSeat() {
        return ticketSeat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_flight_ticket.ticket_seat
     *
     * @param ticketSeat the value for travel_flight_ticket.ticket_seat
     *
     * @mbg.generated Sun Dec 13 17:23:15 CST 2020
     */
    public void setTicketSeat(String ticketSeat) {
        this.ticketSeat = ticketSeat == null ? null : ticketSeat.trim();
    }
}