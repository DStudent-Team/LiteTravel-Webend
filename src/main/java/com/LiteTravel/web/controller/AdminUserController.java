package com.LiteTravel.web.controller;

import com.LiteTravel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
