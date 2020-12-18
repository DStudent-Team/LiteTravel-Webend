package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Flight.FlightDTO;
import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightOrderController {
    @Autowired
    FlightService flightService;

    @PostMapping("/evaluateOrder")
    public ResponseDTO evaluateOrder(@RequestBody FlightDTO flightDTO){
        Double price = flightService.evaluateOrder(flightDTO);
        if (price >= 0){
            return ResponseDTO.success(price);
        }
        else{
            return ResponseDTO.errorOf(501, "请求的数据有误!");
        }
    }
}
