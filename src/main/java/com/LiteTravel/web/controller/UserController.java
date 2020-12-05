package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.DTO.UserInfoDTO;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{userId}")
    public String toUser(@PathVariable("userId") Integer userId, ModelMap model){
        UserInfo info = userService.selectInfoByUserId(userId);
        model.addAttribute("info", info);
        return "user";
    }

    @PutMapping("/user")
    public String updateUser(UserInfo userInfo, HttpSession session){
        userService.updateInfo(userInfo);
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userInfo.getUserId());
        userDTO.setUserName(userInfo.getUserName());
        userDTO.setUserAvatarUri(userInfo.getUserAvatarUri());
        session.setAttribute("user", userDTO);
        return "redirect:/user/" + userInfo.getUserId();
    }


    @GetMapping("/userModify/{userId}")
    public String changeUser(@PathVariable("userId") Integer userId, ModelMap model){
        UserInfo info = userService.selectInfoByUserId(userId);
        model.addAttribute("info", info);
        return "user-modify";
    }
}