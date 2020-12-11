package com.LiteTravel.web.controller;

import com.LiteTravel.web.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManageHotelController {

    @Autowired
    public HotelService hotelService;
}
