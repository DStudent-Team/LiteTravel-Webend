package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.service.BlogService;
import com.LiteTravel.web.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    HotelService hotelService;
    @Resource
    BlogService blogService;

    @GetMapping(path = {"/index", "/index.html"})
    public String indexPage(ModelMap model){
        /*  获取推荐酒店信息 */
        ResultVO hotelResult = hotelService.getHotels(1, 5);
        model.addAttribute("hotels", hotelResult.data);
        ResultVO blogResult = blogService.selectAll(1, 3);
        model.addAttribute("blogs", blogResult.data);
        return "index";
    }
}
