package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.DTO.HotelQueryDTO;
import com.LiteTravel.web.Model.Hotel;
import com.LiteTravel.web.Model.Room;
import com.LiteTravel.web.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /* 带查询条件的分页 */
    private void setPageHotel(Integer page, HotelQueryDTO hotelQueryDTO, ModelMap model){
        /* 向service层分发请求处理 */
        ResultVO  resultVO = hotelService.getHotels(page, 6, hotelQueryDTO);
        /* 分页信息类
         * 参数1：数据集合
         * 参数2：需要展示的最大导航页数*/
        /* 设置筛选页面的筛选项目为Hotel */
//        model.addAttribute("category", "hotel");
        /* 放入数据 */
        /* 放入hotel列表数据 */
        model.addAttribute("hotels", resultVO.data);
        /* 放入查询条件 */
        model.addAttribute("search", hotelQueryDTO);
        /* 放入页面信息数据 */
        model.addAttribute("pageInfo", resultVO.info);
    }

    @PostMapping("/hotels")
    public String HotelSearchList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  HotelQueryDTO hotelQueryDTO, ModelMap model) {
        setPageHotel(page, hotelQueryDTO, model);
        return "hotels";
    }


    @GetMapping("/hotel/{hotelId}")
    public String Hotel(@PathVariable("hotelId") Integer hotelId, ModelMap model){
        /* 获取酒店基本信息 */
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + 60 * 60 * 24 * 1000);
        HotelDTO hotel = hotelService.selectHotelById(hotelId, true, startTime, endTime);
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

    /**
     * 酒店增删改方法
     * @param hotelDTO
     */
    @PostMapping("/manage/hotel")
    public String insertOrUpdateHotel(HotelDTO hotelDTO){
        //通过检索id值是否为空判断是insert还是update,返回值0表示insert，1是update
        int i = hotelService.checkHotelId(hotelDTO);
        if(i == 0){

            /*插入酒店信息,checkHotelByName()是查询是否存在此酒店，存在则不能插入*/
            List<Hotel> hotel = hotelService.checkHotelByName(hotelDTO);
            if(hotel.size() > 0){
                //数据库中存在酒店，不可添加
                System.out.println("酒店已存在！");
            }
            else{
                hotelService.insertHotel(hotelDTO);
            }
        }
        else{

            /*更新酒店信息*/
            int result = hotelService.updateHotel(hotelDTO);
            if(result == 0){
                System.out.println("修改失败");
            }
        }
        return "redirect:/manage/hotels";
    }

    //delete
    @DeleteMapping("/manage/hotel/{hotelId}")
    public String deleteHotel(@PathVariable("hotelId") Integer hotelId){

        hotelService.deleteHotel(hotelId);
        return "redirect:/manage/hotels";
    }

    @RequestMapping("/room")
    public String Hotel(@RequestParam("hotelId") Integer hotelId,
                        @RequestParam("startTime") Date startTime,
                        @RequestParam("endTime") Date endTime, ModelMap model){
        /* 获取酒店基本信息 */
        HotelDTO hotel = hotelService.selectHotelById(hotelId, true, startTime, endTime);


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
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        System.out.println("成功");
        return "hotel-single";
    }

}
