package com.LiteTravel.web.controller;

import org.springframework.stereotype.Controller;

@Controller
public class OrderSearchController {

//    @Autowired
//    SearchService searchService;
//
//
//
//    /* 使用PageHelper获得并设置 分页数据 */
//    private void setPageHotelOrder(Integer page, ModelMap model, HotelOrderQueryDTO hotelOrderQueryCriteriaDTO) throws ParseException {
//        /* 向service层分发请求处理 */
//        ResultVO resultVO = searchService.getOrders(page, 6, 6, hotelOrderQueryCriteriaDTO);
//        List<HotelOrderBlockDTO> hotelOrders = resultVO.data;
//        /* 分页信息类
//         * 参数1：数据集合
//         * 参数2：需要展示的最大导航页数*/
//        PageInfo<HotelOrderBlockDTO> info = resultVO.info;
//        /* 设置筛选页面的筛选项目为Hotel */
//        model.addAttribute("category", "hotel");
//        /* 放入数据 */
//        /* 放入hotel列表数据 */
//        model.addAttribute("orders", hotelOrders);
//        /* 放入页面信息数据 */
//        model.addAttribute("pageInfo", info);
//    }
//
//
//
//    @GetMapping("/search")
//    public String getResult(HttpSession httpSession, ModelMap model, HotelOrderQueryDTO hotelOrderQueryCriteriaDTO) throws ParseException {
//
//        setPageHotelOrder(1, model, hotelOrderQueryCriteriaDTO);
//
//        //暂无页面
//        return "search";
//    }
//

}

