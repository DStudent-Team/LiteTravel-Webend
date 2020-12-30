package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.DTO.HotelQueryDTO;
import com.LiteTravel.web.Model.Hotel;
import com.LiteTravel.web.Model.User;
import com.LiteTravel.web.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    public HotelService hotelService;

    /*-----------------------------------------------------------------*/

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

    /*酒店后台页面数据获取*/
    @GetMapping("/manage/hotels")
    public String MangeHotelList(ModelMap model){
        setPageHotel(1, model);
        return "hotel/list";
    }

    /*-----------------------------------------------------------------*/

    /*酒店后台房间管理根据管理员id信息获取数据*/
    @GetMapping("manage/rooms")
    public String hotelRoomList(@RequestParam(value = "page", defaultValue = "1")Integer page, ModelMap model,
        HttpSession session){
        /*获取session对象*/
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        /*通过session获取管理员id，从而得到他管理的酒店id*/
        ResultVO result = hotelService.getAllRooms(page, 6,userDTO.userId);
        List<Integer> hotelIds = hotelService.getHotelByManagerId(userDTO.userId);
        session.setAttribute("hotelList", hotelIds);
        model.addAttribute("rooms",result.data);
        model.addAttribute("pageInfo", result.info);
        return "room/list";
    }

    /*---------------------------------------------*/
    /*酒店管理点击床位跳转酒店床位管理页*/
    @PostMapping("manage/roomBed/{roomId}")
    public String roomBed(@PathVariable("roomId") Integer roomId,ModelMap model,HttpSession session,
                          @RequestParam(value = "page", defaultValue = "1")Integer page){
        hotelService.getRoomBeds(page, 6, roomId,model,session);
        return "room/roomBed";
    }

    /*-----------------------------------------------------------------*/

    /*床位数据获取*/
    @GetMapping("manage/beds")
    public String bedList(@RequestParam(value = "page", defaultValue = "1")Integer page, ModelMap model){
        ResultVO result = hotelService.getAllBeds(page, 6);
        model.addAttribute("beds",result.data);
        model.addAttribute("pageInfo", result.info);
        return "bed/list";
    }

    /*-----------------------------------------------------------------*/

}
