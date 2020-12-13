package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.DTO.UserInfoDTO;
import com.LiteTravel.web.DTO.UserManageDTO;
import com.LiteTravel.web.Model.User;
import com.LiteTravel.web.Model.UserExample;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.mapper.UserMapper;
import com.LiteTravel.web.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

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
    @PostMapping("/manage/user")
    public String insertUser(UserManageDTO userManageDTO){
        if(userManageDTO.getUserId() == null){
            User user = new User();
            user.setUserCode(userManageDTO.getUserCode());
            user.setUserPassword(userManageDTO.getUserPassword());
            user.setUserState(1);
            userService.insert(user);

            UserInfo userinfo = new UserInfo();
//            UserExample userExample = new UserExample();
//            userExample.createCriteria()
//                       .andUserCodeEqualTo(user.getUserCode());
//            List<User> userList = userMapper.selectByExample(userExample);
//            userinfo.setUserId();
            userinfo.setUserName(userManageDTO.getUserName());
//        设置信息初始化值
            userinfo.setUserGender(0);
            userinfo.setUserBirth(new Date());
            userinfo.setUserAvatarUri("avatar.jpg");
            userService.insert(userinfo);
            System.out.println("保存成功！"+user);
        }
        return "redirect:/manage/users";
    }

    @PutMapping("manage/user")
    public String updateUser(UserManageDTO userManageDTO){
        User user = new User();
        user.setUserCode(userManageDTO.getUserCode());
        user.setUserPassword(userManageDTO.getUserPassword());
        user.setUserState(1);
        return "redirect:/manage/users";
    }
}