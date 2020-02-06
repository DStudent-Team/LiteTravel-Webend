package com.LiteTravel.web.controller;

import com.LiteTravel.web.mapper.HotelMapper;
import com.LiteTravel.web.po.Hotel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    public HotelMapper hotelMapper;
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
        /* 分页：
        * 参数1: 第几页
        * 参数2: 每页展示几个数据 */
        PageHelper.startPage(page, 6    );
        List<Hotel> hotels = hotelMapper.getHotels();
        /* 分页信息类
        * 参数1：数据集合
        * 参数2：需要展示的最大导航页数*/
        PageInfo<Hotel> info = new PageInfo<>(hotels, 5);
        /* 设置筛选页面的筛选项目为Hotel */
//        model.addAttribute("category", "hotel");
        /* 放入数据 */
        /* 放入hotel列表数据 */
        model.addAttribute("hotels", hotels);
        /* 放入页面信息数据 */
        model.addAttribute("pageInfo", info);
    }

    @GetMapping("/hotel/{id}")
    public String Hotel(@PathVariable("id") Integer id, ModelMap model){
        Hotel hotel = hotelMapper.getHotelById(id);
        model.addAttribute("hotel", hotel);
        return "hotel-single";
    }

}
