package com.travelplatform.web.controller;

import com.travelplatform.web.mapper.HotelMapper;
import com.travelplatform.web.po.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class HotelController {
    @Autowired
    public HotelMapper hotelMapper;
    @PostMapping("/hotels")
    public String HotelList(ModelMap model){
        Collection<Hotel> hotels = hotelMapper.getHotels();
        /*设置筛选条件为Hotel*/
        model.addAttribute("category", "hotel");
        model.addAttribute("hotels", hotels);
        return "list";
    }

    @PostMapping("/hotel/{id}")
    public String Hotel(@RequestParam("id") Integer id, ModelMap model){
        Hotel hotel = hotelMapper.getHotelById();
        model.addAttribute("hotel", hotel);
        return "hotel";
    }

}
