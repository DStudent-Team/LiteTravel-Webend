package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Flight.FlightDTO;
import com.LiteTravel.web.DTO.Flight.FlightReserveDTO;
import com.LiteTravel.web.DTO.Flight.FlightSearchDTO;
import com.LiteTravel.web.DTO.Flight.TransactionDTO;
import com.LiteTravel.web.DTO.Region.RegionDTO;
import com.LiteTravel.web.DTO.Region.RegionSearchDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.Model.User;
import com.LiteTravel.web.service.FlightService;
import com.LiteTravel.web.service.RegionService;
import com.LiteTravel.web.service.Utils.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FlightController {
    @Autowired
    FlightService flightService;
    @Autowired
    RegionService regionService;

    @Resource
    private MoneyService moneyService;

    /*提交预约*/
    @PostMapping("flight/submit")
    public String submitFlight(FlightDTO flightDTO){
        // 提交请求后生成订单DTO, 先拆开来看看能不能用, 能用再合并
        System.out.println(flightDTO);
        Integer flightId = flightService.submitFlight(flightDTO);
//        /*发送submit请求,跳转到详细预约信息界面*/
        return "redirect:/flight/"+flightId;
    }
    /*选中服务*/
    @PostMapping("flight/reserve/")
    public String confirmReserve(FlightReserveDTO flightReserveDTO){
        flightService.confirmReserve(flightReserveDTO);
        return "redirect:/flight/" + flightReserveDTO.getFlightId();
    }
    /*撤销模块*/
    @PostMapping("flight/withdraw/")
    public String cancelReserve(FlightReserveDTO flightReserveDTO){
        flightService.withdrawReserve(flightReserveDTO);
        return "redirect:/flight/" + flightReserveDTO.getFlightId();

    }
    /*支付模块*/
    @PostMapping("flight/pay/")
    public String payFlight(FlightReserveDTO flightReserveDTO, ModelMap model, HttpSession session){
        /* 转账 */
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        if (userDTO == null){
            model.addAttribute("message", "请登录");
            return "redirect:/flights";
        }
        boolean flag = moneyService.transaction(userDTO.userId, flightReserveDTO.getCompanyId(), flightReserveDTO.getTotal());
        if (!flag){
            model.addAttribute("message", "交易失败");
            return "redirect:/flights";
        }else{
            model.addAttribute("message", "交易成功");
            flightService.payFlight(flightReserveDTO);
            return "redirect:/flight/" + flightReserveDTO.getFlightId();
        }
    }

    @PostMapping("flight/unPay")
    public String unPayFlight(FlightReserveDTO flightReserveDTO, ModelMap model, HttpSession session){
        //判断用户是否登录
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        if (userDTO == null){
            model.addAttribute("message", "请登录");
            return "redirect:/flights";
        }
        //回退交易
        moneyService.unTransaction(userDTO.userId, flightReserveDTO.getCompanyId(), flightReserveDTO.getTotal());
        //修改状态为未支付
        flightService.UpdateFlightStatus(flightReserveDTO.getFlightId(), 2);
        return "redirect:/flight/" + flightReserveDTO.getFlightId();
    }


    @GetMapping("flights")
    public String getFlights(@RequestParam(value = "page",defaultValue = "1")Integer page, ModelMap model, HttpSession session){
        //需要生成查询信息, 以保留查询状态
        //同样需要生成查询地址信息, 与预约填单之间分开
        //生成订单列表允许用户查看
        UserDTO user = (UserDTO) session.getAttribute("user");
        if (user == null){
            return "redirect:/login";
        }
        ResultVO resultVO = flightService.getFlights(page, 6, 0, user.getUserId());
        model.addAttribute("flights", resultVO.data);
        model.addAttribute("pageInfo", resultVO.info);
        return "flights";
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


    @GetMapping("flight/{flightId}")
    public String getFlight(@PathVariable("flightId") Integer flightId, ModelMap model, HttpSession session){
        // 额外返回余额信息
        UserDTO user = (UserDTO) session.getAttribute("user");
        model.addAttribute("userMoney", moneyService.getMoney(user.getUserId()));

        FlightDTO flightDTO = flightService.getFlightById(flightId);
        model.addAttribute("flight", flightDTO);
        return "flight";
    }

}
