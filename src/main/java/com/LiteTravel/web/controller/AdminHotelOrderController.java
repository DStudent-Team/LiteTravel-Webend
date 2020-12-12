package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminHotelOrderController {
    @Autowired
    HotelOrderService hotelOrderService;

    @GetMapping("/manage/orders")
    public String list(ModelMap model){
        ResultVO resultVO = hotelOrderService.getOrders(1, 10);
        model.addAttribute("orders", resultVO.data);
        return "order/list";
    }

    @GetMapping("/manage/order/{orderId}")
    @Transactional
    public String confirmOrder(@PathVariable("orderId") Integer orderId){
        hotelOrderService.confirmOrder(orderId);
        return "redirect:/manage/orders";
    }

    @DeleteMapping("/manage/order/{orderId}")
    @Transactional
    public String deleteOrder(@PathVariable("orderId") Integer orderId) {
        hotelOrderService.deleteOrder(orderId);
        return "redirect:/manage/orders";
    }
}
