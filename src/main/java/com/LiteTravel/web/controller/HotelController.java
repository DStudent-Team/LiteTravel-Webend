package com.LiteTravel.web.controller;

import com.LiteTravel.web.mapper.HotelMapper;
import com.LiteTravel.web.po.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Controller
public class HotelController {
    @Autowired
    public HotelMapper hotelMapper;
    @GetMapping("/hotels")
    public String HotelList(ModelMap model){
        Collection<Hotel> hotels = hotelMapper.getHotels();
        /* 设置筛选页面的筛选项目为Hotel */
//        model.addAttribute("category", "hotel");
        /* 放入数据 */
        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @GetMapping("/hotel/{id}")
    public String Hotel(@PathVariable("id") Integer id, ModelMap model){
        Hotel hotel = hotelMapper.getHotelById(id);
        model.addAttribute("hotel", hotel);
        return "hotel-single";
    }

}
