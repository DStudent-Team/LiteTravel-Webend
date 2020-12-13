package com.LiteTravel.web.service;

import com.LiteTravel.web.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    FlightMapper flightMapper;

    public void submitFlight(){

    }
}
