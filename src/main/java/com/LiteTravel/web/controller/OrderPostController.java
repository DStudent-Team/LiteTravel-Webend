package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.HotelOrderConfirmDTO;
import com.LiteTravel.web.DTO.HotelOrderPayDTO;
import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.DTO.HotelOrderDetailDTO;
import com.LiteTravel.web.Model.HotelOrder;
import com.LiteTravel.web.Model.HotelOrderDetail;
import com.LiteTravel.web.service.HotelOrderService;
import com.LiteTravel.web.service.HotelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderPostController {
    @Autowired
    HotelOrderService hotelOrderService;

    @Autowired
    HotelService hotelService;

    @PostMapping("/book/submit")
    @Transactional
    public ResponseDTO bookHotel(@RequestBody HotelOrderConfirmDTO hotelOrderConfirmDTO){
        //生成订单信息，成功则跳转至订单页面
        HotelOrder hotelOrder = new HotelOrder();
        BeanUtils.copyProperties(hotelOrderConfirmDTO, hotelOrder);
        hotelOrder.setStatus("0");
        hotelOrder.setCreateDate(new Date());
        System.out.println(hotelOrder.toString());
        List<HotelOrderDetail> hotelOrderDetails = new ArrayList<>();
        for (HotelOrderDetailDTO roomOrder:hotelOrderConfirmDTO.getRooms()) {
            HotelOrderDetail hotelOrderDetail = new HotelOrderDetail();
            BeanUtils.copyProperties(roomOrder, hotelOrderDetail);
            System.out.println(hotelOrderDetail.toString());
            hotelOrderDetails.add(hotelOrderDetail);
        }

        Integer orderId = hotelOrderService.insertHotelOrder(hotelOrder, hotelOrderDetails);
        return ResponseDTO.success(orderId);
    }

    @PostMapping("/order/pay")
    @Transactional
    public ResponseDTO payOrder(@RequestBody HotelOrderPayDTO hotelOrderPayDTO){
        HotelOrder hotelOrder = new HotelOrder();
        BeanUtils.copyProperties(hotelOrderPayDTO, hotelOrder);
        int id = hotelOrderService.updateHotelOrder(hotelOrder);
        System.out.println(id);
        return ResponseDTO.success(hotelOrderPayDTO.getOrderId());

    }

}
