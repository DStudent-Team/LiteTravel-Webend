package com.travelplatform.web.controller;

import com.travelplatform.web.mapper.UserInfoMapper;
import com.travelplatform.web.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
    @Autowired
    UserInfoMapper userInfoMapper;

    @GetMapping("/user/{userId}")
    public String toUser(@PathVariable("userId") Integer userId, ModelMap model){
        UserInfo info = userInfoMapper.findInfoById(userId);
        model.addAttribute("info", info);
        return "user";
    }

}
