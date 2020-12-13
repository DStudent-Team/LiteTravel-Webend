package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Flight.FlightDTO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping
    public String toFlight(){
        return "flight";
    }

    @PostMapping
    public String submitFlight(FlightDTO flightDTO, ModelMap model, HttpSession httpSession){
        // 提交请求后生成订单DTO, 先拆开来看看能不能用, 能用再合并
        // FlightOrderDTO flightOrder = flightService.submitFlight(flightDTO);
        // model.addAttribute("order", flightOrder);
        /*发送submit请求,跳转到订单页面,进行订单设置*/
        UserDTO user = (UserDTO) httpSession.getAttribute("user");
        model.addAttribute("userId", user.userId);
        return "flight-order";
    }
}
