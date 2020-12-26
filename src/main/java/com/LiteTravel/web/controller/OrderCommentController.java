package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.HotelOrder.DisplayOrderCommentDTO;
import com.LiteTravel.web.DTO.HotelOrder.OrderCommentDTO;
import com.LiteTravel.web.Model.OrderComment;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.service.OrderCommentService;
import com.LiteTravel.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xiaobai
 * @Date 2020/12/26 20:17
 * @Version 1.0
 */
@Controller
public class OrderCommentController {

    @Resource
    private UserService userService;

    @Resource
    private OrderCommentService orderCommentService;

    @PostMapping("/saveOrder")
    public String saveOrderComment(OrderCommentDTO orderCommentDTO, Model model){

        int flag = orderCommentService.saveOrderComment(orderCommentDTO);
        List<OrderComment> orderComments = orderCommentService.listOrderCommentsByHotelId(orderCommentDTO.getHotelId());

        if (flag == 1){
            model.addAttribute("oc_message", "添加评价成功");
            return "redirect:hotel/" + orderCommentDTO.getHotelId();
        }else{
            model.addAttribute("oc_message", "添加失败");
            return "redirect:order/" + orderCommentDTO.getOrderId();
        }
    }

    private List<DisplayOrderCommentDTO> listDisplayOrderComment(List<OrderComment> orderComments){
        for (OrderComment orderComment : orderComments){
//            userService.selectInfoByUserId()
        }
        return null;
    }

}
