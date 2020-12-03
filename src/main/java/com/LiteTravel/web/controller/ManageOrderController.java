package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.HotelOrderBlockDTO;
import com.LiteTravel.web.service.HotelOrderService;
import com.LiteTravel.web.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManageOrderController {
    @Autowired
    HotelOrderService hotelOrderService;

    @GetMapping("/manage/orders")
    public String list(ModelMap model){
        List<HotelOrderBlockDTO> orders = hotelOrderService.getOrders(1, 10);
        System.out.println(orders.get(0).toString());
        model.addAttribute("orders", orders);
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
