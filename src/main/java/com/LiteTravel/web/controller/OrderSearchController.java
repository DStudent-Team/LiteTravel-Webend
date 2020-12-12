package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.HotelOrderBlockDTO;
import com.LiteTravel.web.DTO.HotelOrderQueryCriteriaDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.service.SearchService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderSearchController {

    @Autowired
    SearchService searchService;



    /* 使用PageHelper获得并设置 分页数据 */
    private void setPageHotelOrder(Integer page, ModelMap model, HotelOrderQueryCriteriaDTO hotelOrderQueryCriteriaDTO) throws ParseException {
        /* 向service层分发请求处理 */
        ResultVO resultVO = searchService.getOrders(page, 6, 6, hotelOrderQueryCriteriaDTO);
        List<HotelOrderBlockDTO> hotelOrders = resultVO.resultList;
        /* 分页信息类
         * 参数1：数据集合
         * 参数2：需要展示的最大导航页数*/
        PageInfo<HotelOrderBlockDTO> info = resultVO.info;
        /* 设置筛选页面的筛选项目为Hotel */
        model.addAttribute("category", "hotel");
        /* 放入数据 */
        /* 放入hotel列表数据 */
        model.addAttribute("orders", hotelOrders);
        /* 放入页面信息数据 */
        model.addAttribute("pageInfo", info);
    }



    @GetMapping("/search")
    public String getResult(HttpSession httpSession, ModelMap model, HotelOrderQueryCriteriaDTO hotelOrderQueryCriteriaDTO) throws ParseException {

        setPageHotelOrder(1, model, hotelOrderQueryCriteriaDTO);

        //暂无页面
        return "search";
    }


}


