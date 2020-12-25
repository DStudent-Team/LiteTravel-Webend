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
import javax.websocket.server.PathParam;
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
        return "/flight/reserves";
    }
    /* 获取特定的服务*/
    @PostMapping("/manage/reserves")
    public String getReserves(@RequestParam(value = "page", defaultValue = "1")Integer page, FlightReserveDTO flightReserveDTO, ModelMap model){
        ResultVO result = flightService.getReserves(page, 10, flightReserveDTO);
        model.addAttribute("reserves", result.data);
        model.addAttribute("pageInfo", result.info);
        return "/manage/reserves";
    }
    /* 删除飞机行程信息*/
    @PostMapping("manage/deleteFlight")
    public String deleteFlight(Integer flightId, ModelMap map){
        int id = flightService.deleteFlight(flightId);
        if(id == 1){
            return "redirect:/manage/flights";
        }else{
            map.put("msg","删除失败！");
            return "redirect:/manage/flights";
        }

    }
    /*删除提供的机票服务信息*/
    @PostMapping("/manage/deleteReserve")
    public String deleteReserve(Integer reserveId, ModelMap map){
        int id = flightService.deleteReserve(reserveId);
        if (id == 1) {
            return "redirect:/manage/reserves";
        }else{
            map.put("msg","删除失败！");
            return "redirect:/manage/reserves";
        }
    }
    /* 更新机票服务信息 */
    @PostMapping("/manage/updateReserve")
    public String updateReserve(@PathParam("reserveId") Integer reserveId,
                          @PathParam("service") String service, ModelMap map) {
        int id = flightService.updateReserve(reserveId, service);
        if(id == 1){
            return "redirect:/manage/reserves";
        }else{
            map.put("msg","更新成功！");
            return "redirect:/manage/reserves";
        }
    }
}
