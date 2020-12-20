package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminUserController {
    @Autowired
    UserService userService;
    @GetMapping("/manage/users")
    public String userList(@RequestParam(value = "page", defaultValue = "1")Integer page, ModelMap model){
        ResultVO resultVO = userService.getUsers(page, 7);
        model.addAttribute("users", resultVO.data);
        model.addAttribute("pageInfo", resultVO.info);
        return "user/list";
    }
}
