package com.LiteTravel.web.DTO.Flight;

import lombok.Data;

import java.util.Date;

@Data
public class FlightDTO {
    Integer flightId;
    Integer userId;
    Integer flightFrom;
    Integer flightTo;
    Date flightDepart;
    Date flightArrived;
    Float flightPrice;
    Integer flightSeats;
}
