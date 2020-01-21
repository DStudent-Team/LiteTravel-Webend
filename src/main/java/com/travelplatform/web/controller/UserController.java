package com.travelplatform.web.controller;

import com.travelplatform.web.mapper.UserMapper;
import com.travelplatform.web.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/toUser/{token}")
    public String toUser(@PathVariable("token") Integer id, ModelMap model){
        User user = userMapper.findUserById(id);
        model.addAttribute("User", user);
        return "user";
    }

}
