package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.HotelOrderBlockDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.User;
import com.LiteTravel.web.service.HotelOrderService;
import com.LiteTravel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminUserController {
    @Autowired
    UserService userService;
//    @GetMapping("/manage/users")
//    public String userList(ModelMap model){
//        List<User> userList = userService.getUsers();
//        model.addAttribute("orders", resultVO.data);
//        return "user/list";
//    }
}
