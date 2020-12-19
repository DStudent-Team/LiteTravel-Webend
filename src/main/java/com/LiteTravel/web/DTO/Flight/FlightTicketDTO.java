package com.LiteTravel.web.DTO.Flight;

import lombok.Data;

@Data
public class FlightTicketDTO {
    Integer reserveId;
    Integer ticketId;
    String seat;
    String price;
}
