package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Flight.FlightReserveDTO;
import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.Model.FlightReserveExample;
import com.LiteTravel.web.Model.User;
import com.LiteTravel.web.mapper.FlightReserveMapper;
import com.LiteTravel.web.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AdminFlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    FlightReserveMapper flightReserveMapper;

    @Autowired
    FlightReserveMapper flightMapper;

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
    /* 获取特定的服务*/
    @PostMapping("/manage/reserves")
    public String getReserves(@RequestParam(value = "page", defaultValue = "1")Integer page, FlightReserveDTO flightReserveDTO, ModelMap model){
        ResultVO result = flightService.getReserves(page, 10, flightReserveDTO);
        model.addAttribute("reserves", result.data);
        model.addAttribute("pageInfo", result.info);
        return "/manage/reserves";
    }
    /* 删除机票预约*/
    /*删除用户信息*/
    @PostMapping("manage/deleteFlight")
    public String deleteUser(Integer flightId, ModelMap map){
        int id = flightService.deleteFlight(flightId);
        if(id == 1){
            return "redirect:/manage/flights";
        }else{
            map.put("msg","删除失败！");
            return "redirect:/manage/flights";
        }

    }
}
