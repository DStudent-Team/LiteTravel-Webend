package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.HotelOrderQueryDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.service.HotelOrderSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@Controller
public class HotelOrderSearchController {

//    @Autowired
//    HotelOrderSearchService hotelOrderSearchService;



//    /* 使用PageHelper获得并设置 分页数据 */
//    private void setPageHotelOrder(Integer page, ModelMap model, HotelOrderQueryDTO hotelOrderQueryDTO) {
//        /* 向service层分发请求处理 */
//        ResultVO resultVO = hotelOrderSearchService.getOrders(page, 6, hotelOrderQueryDTO);
//        /* 分页信息类
//         * 参数1：数据集合
//         * 参数2：需要展示的最大导航页数*/
//        /* 设置筛选页面的筛选项目为Hotel */
//        model.addAttribute("category", "hotel");
//        /* 放入数据 */
//        /* 放入hotel列表数据 */
//        model.addAttribute("orders", resultVO.data);
//        /* 放入页面信息数据 */
//        model.addAttribute("pageInfo", resultVO.info);
//    }
//
//
//
//    @PostMapping("/orders")
//    public String getResult(@RequestBody HotelOrderQueryDTO hotelOrderQueryDTO,
//                            ModelMap model) {
//
//        setPageHotelOrder(1, model, hotelOrderQueryDTO);
//
//        //暂无页面
//        return "search";
//    }

//    @PostMapping("/orders/{page}")
//    public String getResultByPages(@PathVariable("page") Integer page,
//                                   @RequestBody HotelOrderQueryDTO hotelOrderQueryDTO,
//                                   ModelMap model) {
//
//        setPageHotelOrder(page, model, hotelOrderQueryDTO);
//
//        //暂无页面
//        return "search";
//    }

}


