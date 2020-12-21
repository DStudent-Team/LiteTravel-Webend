package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Flight.FlightReserveDTO;
import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AdminFlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/manage/flights")
    public String getFlights(@RequestParam(value = "page", defaultValue = "1")Integer page, ModelMap model, HttpSession session){
        ResultVO result = flightService.getFlights(page, 10, ((UserDTO) session.getAttribute("user")).userId);
        model.addAttribute("flights", result.data);
        model.addAttribute("pageInfo", result.info);
        return "/flight/list";
    }

    @PostMapping("/manage/reserve")
    @ResponseBody
    public Object SubmitReserve(@RequestBody FlightReserveDTO reserveDTO){
        flightService.submitReserve(reserveDTO);
        return ResponseDTO.successOf();
    }
    
    /* 获取所有提供的服务 */
    @GetMapping("/manage/reserves")
    public String getReserves(@RequestParam(value = "page", defaultValue = "1")Integer page, ModelMap model){
        ResultVO result = flightService.getReserves(page, 10, new FlightReserveDTO());
        model.addAttribute("reserves", result.data);
        model.addAttribute("pageInfo", result.info);
        return "/manage/reserves";
    }

    @PostMapping("/manage/reserves")
    public String getReserves(@RequestParam(value = "page", defaultValue = "1")Integer page, FlightReserveDTO flightReserveDTO, ModelMap model){
        ResultVO result = flightService.getReserves(page, 10, flightReserveDTO);
        model.addAttribute("reserves", result.data);
        model.addAttribute("pageInfo", result.info);
        return "/manage/reserves";
    }
}
