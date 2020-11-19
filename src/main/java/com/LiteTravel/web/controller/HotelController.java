package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.exception.CustomizeErrorCode;
import com.LiteTravel.web.exception.CustomizeException;
import com.LiteTravel.web.service.HotelService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HotelController {
    @Autowired
    public HotelService hotelService;

    /* todo 酒店列表实际上用了两个接口来接受两个不同的请求, 冗余了, 试试可不可以更加尽可能的重用 */
    /* 默认第一页 */
    @GetMapping("/hotels")
    public String HotelList(ModelMap model){
        setPageHotel(1, model);
        return "hotels";
    }
    /* 点击页面数切换 分页显示酒店列表 */
    @GetMapping("/hotels/{page}")
    public String HotelPage(@PathVariable("page") Integer page, ModelMap model){
        setPageHotel(page, model);
        return "hotels";
    }
    /* 使用PageHelper获得并设置 分页数据 */
    private void setPageHotel(Integer page, ModelMap model){
        /* 向service层分发请求处理 */
        List<HotelDTO> hotels = hotelService.getHotels(page, 6);
        /* 分页信息类
        * 参数1：数据集合
        * 参数2：需要展示的最大导航页数*/
        PageInfo<HotelDTO> info = new PageInfo<>(hotels, 5);
        /* 设置筛选页面的筛选项目为Hotel */
//        model.addAttribute("category", "hotel");
        /* 放入数据 */
        /* 放入hotel列表数据 */
        model.addAttribute("hotels", hotels);
        /* 放入页面信息数据 */
        model.addAttribute("pageInfo", info);
    }

    @GetMapping("/hotel/{hotelId}")
    public String Hotel(@PathVariable("hotelId") Integer hotelId, ModelMap model){
        /* 获取酒店基本信息 */
        HotelDTO hotel = hotelService.selectHotelById(hotelId, true);

        /* todo 获取酒店具体介绍数据 */
        /* done 获取房间块展示数据 */
        /* todo 获取房间可折叠展示块信息 */

        List<HotelDTO> relatedHotels = hotelService.getHotels(hotelId, 1, 3);
        /* 设置酒店基本信息数据 */
        model.addAttribute("hotel", hotel);
        /* todo 设置酒店具体介绍数据 */
        /* done 设置房间块展示数据 */
        /* todo 设置房间可折叠展示块信息 */

        /* 设置推荐酒店基本信息数据 */
        /* todo 设计推荐算法 */
        model.addAttribute("hotels", relatedHotels);

        return "hotel-single";
    }

    @PostMapping("/book")
    @Transactional
    public String bookHotel(@RequestBody HotelOrderDTO hotelOrderDTO,
                            ModelMap model){
        System.out.println(hotelOrderDTO.toString());
        HotelOrderCreateDTO hotelOrderCreateDTO = new HotelOrderCreateDTO();
        BeanUtils.copyProperties(hotelOrderDTO, hotelOrderCreateDTO);
        hotelOrderCreateDTO.setHotel(hotelService.selectHotelById(hotelOrderCreateDTO.getHotelId(), false));
        hotelOrderCreateDTO.setRoom(hotelService.selectRoomById(hotelOrderCreateDTO.getRoomId()));
        hotelOrderCreateDTO.setTotal(hotelOrderDTO.getPrice() * hotelOrderDTO.getDays() * hotelOrderDTO.getTravelers());
        System.out.println(hotelOrderCreateDTO.toString());
        model.addAttribute("hotelOrder", hotelOrderCreateDTO);
        return "hotel-order";
    }
}
