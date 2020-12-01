package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.HotelOrderCreateDTO;
import com.LiteTravel.web.DTO.HotelOrderDTO;
import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.service.HotelOrderService;
import com.LiteTravel.web.service.HotelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    HotelOrderService hotelOrderService;

    @Autowired
    HotelService hotelService;

    @PostMapping("/hotel/book")
    @Transactional
    public ResponseDTO bookHotel(@RequestBody HotelOrderDTO hotelOrderDTO){
        System.out.println(hotelOrderDTO.toString());
        HotelOrderCreateDTO hotelOrderCreateDTO = new HotelOrderCreateDTO();
        BeanUtils.copyProperties(hotelOrderDTO, hotelOrderCreateDTO);
        hotelOrderCreateDTO.setHotel(hotelService.selectHotelById(hotelOrderCreateDTO.getHotelId(), false));
        hotelOrderCreateDTO.setRoom(hotelService.selectRoomById(hotelOrderCreateDTO.getRoomId()));
        hotelOrderCreateDTO.setTotal(hotelOrderDTO.getPrice() * hotelOrderDTO.getDays() * hotelOrderDTO.getTravelers());
        System.out.println(hotelOrderCreateDTO.toString());
//        model.addAttribute("hotelOrder", hotelOrderCreateDTO);
//        生成订单信息，成功则跳转至订单页面
        return ResponseDTO.success(hotelOrderCreateDTO);
    }
}
