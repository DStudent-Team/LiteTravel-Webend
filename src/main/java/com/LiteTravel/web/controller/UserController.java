package com.LiteTravel.web.controller;

import com.LiteTravel.web.mapper.UserInfoMapper;
import com.LiteTravel.web.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;

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

    @PutMapping("/user")
    public String updateUser(UserInfo userInfo, HttpSession session){
        userInfoMapper.updateUserInfo(userInfo);
        session.setAttribute("userName", userInfo.userName);
        return "redirect:/user/" + userInfo.userId;
    }

}
