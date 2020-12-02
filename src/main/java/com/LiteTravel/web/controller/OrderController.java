package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.HotelOrderBlockDTO;
import com.LiteTravel.web.DTO.HotelOrderInfoDTO;
import com.LiteTravel.web.DTO.RoomDTO;
import com.LiteTravel.web.service.HotelOrderService;
import com.LiteTravel.web.service.HotelService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderController {
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelOrderService hotelOrderService;

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
        List<HotelOrderBlockDTO> hotelOrders = hotelOrderService.getOrders(page, 6);
        /* 分页信息类
         * 参数1：数据集合
         * 参数2：需要展示的最大导航页数*/
        PageInfo<HotelOrderBlockDTO> info = new PageInfo<>(hotelOrders, 5);
        /* 设置筛选页面的筛选项目为Hotel */
        model.addAttribute("category", "hotel");
        /* 放入数据 */
        /* 放入hotel列表数据 */
        model.addAttribute("orders", hotelOrders);
        /* 放入页面信息数据 */
        model.addAttribute("pageInfo", info);
    }
    @GetMapping("/order/{orderId}")
    public String getHotelOrderInfo(@PathVariable("orderId") Integer orderId, ModelMap model){
        HotelOrderInfoDTO hotelOrderInfoDTO = hotelOrderService.selectByOrderId(orderId);
        hotelOrderInfoDTO.setHotel(hotelService.selectHotelById(hotelOrderInfoDTO.getHotelId(), false));
        hotelOrderInfoDTO.setRooms(hotelOrderInfoDTO.getRooms().stream().peek(hotelOrderDetailDTO -> {
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
