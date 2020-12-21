package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Flight.FlightDTO;
import com.LiteTravel.web.DTO.Flight.FlightReserveDTO;
import com.LiteTravel.web.DTO.Flight.FlightSearchDTO;
import com.LiteTravel.web.DTO.Region.RegionDTO;
import com.LiteTravel.web.DTO.Region.RegionSearchDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.service.FlightService;
import com.LiteTravel.web.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FlightController {
    @Autowired
    FlightService flightService;
    @Autowired
    RegionService regionService;


    @GetMapping("flights")
    public String getFlights(@RequestParam(value = "page",defaultValue = "1")Integer page, ModelMap model){
        //需要生成查询信息, 以保留查询状态
        //同样需要生成查询地址信息, 与预约填单之间分开
        //生成订单列表允许用户查看
        ResultVO resultVO = flightService.getFlights(page, 6, 0);
        model.addAttribute("flights", resultVO.data);
        model.addAttribute("pageInfo", resultVO.info);
        return "flights";
    }


    @PostMapping("flight/submit")
    public String submitFlight(FlightDTO flightDTO){
        // 提交请求后生成订单DTO, 先拆开来看看能不能用, 能用再合并
        System.out.println(flightDTO);
        Integer flightId = flightService.submitFlight(flightDTO);
//        /*发送submit请求,跳转到详细预约信息界面*/
        return "redirect:/flight/"+flightId;
    }

    @GetMapping("flight/{flightId}")
    public String getFlight(@PathVariable("flightId") Integer flightId, ModelMap model){
        FlightDTO flightDTO = flightService.getFlightById(flightId);
        model.addAttribute("flight", flightDTO);
        return "flight";
    }

    @PostMapping("flight/reserve/")
    public String confirmReserve(FlightReserveDTO flightReserveDTO){
        flightService.confirmReserve(flightReserveDTO);
        return "redirect:/flight/" + flightReserveDTO.getFlightId();
    }
    @PostMapping("flight/withdraw/")
    public String cancelReserve(FlightReserveDTO flightReserveDTO){
        flightService.withdrawReserve(flightReserveDTO);
        return "redirect:/flight/" + flightReserveDTO.getFlightId();

    }

    @PostMapping("flight/pay/")
    public String payFlight(FlightReserveDTO flightReserveDTO, ModelMap model){
        /* 转账 */


        model.addAttribute("tips","钱不够");
        flightService.payFlight(flightReserveDTO);
        return "redirect:/flight/" + flightReserveDTO.getFlightId();
    }

    @PostMapping("flights")
    public String getFlights(@RequestParam(value = "page",defaultValue = "1")Integer page, ModelMap model,
                             FlightSearchDTO flightSearchDTO, String statusList){
        flightSearchDTO.setFlightStatus(statusList);
        ResultVO resultVO = flightService.getFlights(page, 6, flightSearchDTO);
        model.addAttribute("flights", resultVO.data);
        model.addAttribute("pageInfo", resultVO.info);
        model.addAttribute("search", flightSearchDTO);
        return "flights";
    }

}
