package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.service.HotelOrderService;
import com.LiteTravel.web.service.HotelService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderController {
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelOrderService hotelOrderService;


    @PostMapping("/order")
    @Transactional
    public String bookHotel(@RequestParam("hotelId") Integer hotelId,
                            @RequestParam("roomId") Integer roomId,
                            @RequestParam("userId") Integer userId,
                            @RequestParam("checkIn") String checkIn,
                            @RequestParam("checkOut") String checkOut,
                            @RequestParam("roomCount") Integer roomCount,
                            @RequestParam("price") float price, ModelMap model) throws ParseException {
        /*应该全部整理进service中去*/
        HotelOrderInfoDTO hotelOrderInfoDTO = new HotelOrderInfoDTO();
        hotelOrderInfoDTO.setHotelId(hotelId);
        hotelOrderInfoDTO.setUserId(userId);
        hotelOrderInfoDTO.setHotel(hotelService.selectHotelById(hotelId, false));
        hotelOrderInfoDTO.setDetails(hotelService.getHotelOrderDetailByRoomIds(Collections.singletonList(roomId)));
        for (HotelOrderDetailDTO detail: hotelOrderInfoDTO.getDetails()){
            detail.setRoomPrice(price);
            detail.setRoomCount(roomCount);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d");
        Date checkInDate = dateFormat.parse(checkIn);
        Date checkOutDate = dateFormat.parse(checkOut);
        hotelOrderInfoDTO.setCheckIn(checkInDate);
        hotelOrderInfoDTO.setCheckOut(checkOutDate);
        Integer days = (int)((checkOutDate.getTime() - checkInDate.getTime()) / (1000 * 60 * 60 * 24));//计算时间
        hotelOrderInfoDTO.setDays(days);
        /*总价需重新计算*/
        float total = 0;
        for (HotelOrderDetailDTO detail: hotelOrderInfoDTO.getDetails()) {
            total += detail.getRoomCount() * detail.getRoomPrice();
        }
        hotelOrderInfoDTO.setTotal(total);
        model.addAttribute("order", hotelOrderInfoDTO);
        return "hotel-order";
    }

    @GetMapping("/orders")
    public String OrderList(ModelMap model){
        setPageHotelOrder(1, model);
        return "orders";
    }
    /* 点击页面数切换 分页显示酒店列表 */
    @GetMapping("/orders/{page}")
    public String OrderPage(@PathVariable("page") Integer page, ModelMap model){
        setPageHotelOrder(page, model);
        return "orders";
    }

    /* 使用PageHelper获得并设置 分页数据 */
    private void setPageHotelOrder(Integer page, ModelMap model){
        /* 向service层分发请求处理 */
        ResultVO resultVO = hotelOrderService.getOrders(page, 6);
        /* 分页信息类
         * 参数1：数据集合
         * 参数2：需要展示的最大导航页数*/
        /* 设置筛选页面的筛选项目为Hotel */
        model.addAttribute("category", "hotel");
        /* 放入数据 */
        /* 放入hotel列表数据 */
        model.addAttribute("orders", resultVO.data);
        /* 放入页面信息数据 */
        model.addAttribute("pageInfo", resultVO.info);
    }
    @GetMapping("/order/{orderId}")
    public String getHotelOrderInfo(@PathVariable("orderId") Integer orderId, ModelMap model){
        HotelOrderInfoDTO hotelOrderInfoDTO = hotelOrderService.getHotelOrderInfoById(orderId);
        hotelOrderInfoDTO.setHotel(hotelService.selectHotelById(hotelOrderInfoDTO.getHotelId(), false));
        hotelOrderInfoDTO.setDetails(hotelOrderInfoDTO.getDetails().stream().peek(hotelOrderDetailDTO -> {
            RoomDTO roomDTO = hotelService.getRoomDTO(hotelOrderDetailDTO.getRoomId());
            hotelOrderDetailDTO.setRoomName(roomDTO.getRoomName());
            hotelOrderDetailDTO.setRoomWifi(roomDTO.getRoomWifi());
            hotelOrderDetailDTO.setBeds(roomDTO.getBeds());

        }).collect(Collectors.toList()));
        System.out.println(hotelOrderInfoDTO.toString());
        model.addAttribute("order", hotelOrderInfoDTO);
        return "order";
    }
}
