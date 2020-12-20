package com.LiteTravel.web.DTO.Flight;

import lombok.Data;

import java.util.List;

@Data
public class FlightReserveDTO {
    Integer reserveId;
    Integer flightId;
    Float total;
    Boolean selected;
    Integer companyId;
    String companyName;
    String service;
    List<FlightTicketDTO> flightTickets;//所有预定到的机票数据
}
