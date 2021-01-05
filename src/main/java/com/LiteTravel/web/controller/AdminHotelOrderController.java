package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class AdminHotelOrderController {
    @Resource
    HotelOrderService hotelOrderService;

    @GetMapping("/manage/orders")
    public String list(@RequestParam(value = "page",defaultValue = "1")Integer page, ModelMap model){
        ResultVO resultVO = hotelOrderService.getOrders(page, 6);
        model.addAttribute("orders", resultVO.data);
        model.addAttribute("pageInfo", resultVO.info);
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
