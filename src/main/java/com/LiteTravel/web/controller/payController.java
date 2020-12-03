package com.LiteTravel.web.controller;


import com.LiteTravel.web.DTO.HotelOrderPayDTO;
import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.Model.HotelOrder;
import com.LiteTravel.web.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//@RestController
public class payController {
    @Autowired
    HotelOrderService hotelOrderService;

/*    @PostMapping("/order/pay")
    @Transactional
    public ResponseDTO payOrder(@RequestBody HotelOrderPayDTO hotelOrderPayDTO){
        HotelOrder hotelOrder = new HotelOrder();
        hotelOrder.setOrderId(hotelOrderPayDTO.getOrderId());
        hotelOrder.setUserName(hotelOrderPayDTO.getName());
        hotelOrder.setUserPhone(hotelOrderPayDTO.getPhone());
        hotelOrder.setWhenArrived(hotelOrderPayDTO.getArrived());
        hotelOrder.setNote(hotelOrderPayDTO.getNote());
        int id = hotelOrderService.updateHotelOrder(hotelOrder);
        System.out.println(id);
        return ResponseDTO.success(hotelOrderPayDTO.getOrderId());

    }*/
}
