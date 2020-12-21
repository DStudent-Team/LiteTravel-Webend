package com.LiteTravel.web.Model;

public class FlightTicket {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_flight_ticket.ticket_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Integer ticketId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_flight_ticket.reserve_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Integer reserveId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_flight_ticket.ticket_price
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private Float ticketPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_flight_ticket.ticket_seat
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    private String ticketSeat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_flight_ticket.ticket_id
     *
     * @return the value of travel_flight_ticket.ticket_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
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
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_flight_ticket.reserve_id
     *
     * @return the value of travel_flight_ticket.reserve_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public Integer getReserveId() {
        return reserveId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_flight_ticket.reserve_id
     *
     * @param reserveId the value for travel_flight_ticket.reserve_id
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_flight_ticket.ticket_price
     *
     * @return the value of travel_flight_ticket.ticket_price
     *
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
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
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
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
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
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
     * @mbg.generated Mon Dec 21 23:27:15 CST 2020
     */
    public void setTicketSeat(String ticketSeat) {
        this.ticketSeat = ticketSeat == null ? null : ticketSeat.trim();
    }
}