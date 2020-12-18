package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.service.HotelService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HotelController {

    @Autowired
    public HotelService hotelService;

    /* 点击页面数切换 分页显示酒店列表 */
    @GetMapping("/hotels")
    public String HotelPage(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model){
        setPageHotel(page, model);
        return "hotels";
    }
    /* 使用PageHelper获得并设置 分页数据 */
    private void setPageHotel(Integer page, ModelMap model){
        /* 向service层分发请求处理 */
        ResultVO  resultVO = hotelService.getHotels(page, 6);
         /* 分页信息类
        * 参数1：数据集合
        * 参数2：需要展示的最大导航页数*/
        /* 设置筛选页面的筛选项目为Hotel */
//        model.addAttribute("category", "hotel");
        /* 放入数据 */
        /* 放入hotel列表数据 */
        model.addAttribute("hotels", resultVO.data);
        /* 放入页面信息数据 */
        model.addAttribute("pageInfo", resultVO.info);
    }

    @GetMapping("/hotel/{hotelId}")
    public String Hotel(@PathVariable("hotelId") Integer hotelId, ModelMap model){
        /* 获取酒店基本信息 */
        HotelDTO hotel = hotelService.selectHotelById(hotelId, true);

        /* todo 获取酒店具体介绍数据 */
        /* done 获取房间块展示数据 */
        /* todo 获取房间可折叠展示块信息 */

        ResultVO result = hotelService.getHotels(hotelId, 1, 3);
        /* 设置酒店基本信息数据 */
        model.addAttribute("hotel", hotel);
        /* todo 设置酒店具体介绍数据 */
        /* done 设置房间块展示数据 */
        /* todo 设置房间可折叠展示块信息 */

        /* 设置推荐酒店基本信息数据 */
        /* todo 设计推荐算法 */
        model.addAttribute("hotels", result.data);
        return "hotel-single";
    }

    @GetMapping("/manage/hotels")
    public String MangeHotelList(ModelMap model){
        setPageHotel(1, model);
        return "hotel/list";
    }

    //酒店增删改

    //insert

    //update
//    @GetMapping("/manage/hotel/{hotelId}")
//    public String updataHotel(@PathVariable("hotelId") Integer hotelId, ModelMap model){
//        System.out.println(hotelId);
//        HotelDTO hotel = hotelService.selectHotelById(hotelId, true);
//        model.addAttribute("hotel", hotel);
//        return "hotel/list";
//    }

    @PutMapping("/manage/hotel")
    public String updateHotel(HotelDTO hotelDTO){
        hotelService.updateHotel(hotelDTO);
        return "hotel/list";
    }



    //delete
    @DeleteMapping("/manage/hotel/{hotelId}")
    public String deleteHotel(@PathVariable("hotelId") Integer hotelId){

        hotelService.deleteHotel(hotelId);
        return "hotel/list";
    }
}
