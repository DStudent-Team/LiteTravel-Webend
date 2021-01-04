package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.DTO.UserManageDTO;
import com.LiteTravel.web.Model.User;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.mapper.UserInfoMapper;
import com.LiteTravel.web.mapper.UserMapper;
import com.LiteTravel.web.service.UserService;
import com.LiteTravel.web.service.Utils.MoneyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    MoneyService moneyService;


    @GetMapping("/user/{userId}")
    public String toUser(@PathVariable("userId") Integer userId, ModelMap model, Model m){
        UserInfo info = userService.selectInfoByUserId(userId);
        m.addAttribute("money", moneyService.getMoney(userId));
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

    /**
     * 加钱
     * @param userId
     * @param money
     * @param password
     * @param model
     * @return
     */
    @PostMapping("/addMoney")
    public String addMoney(Integer userId, String money, String password, Model model){
        if ("".equals(money) || "".equals(money)){
            model.addAttribute("message", "请输入");
            return "redirect:/user/" + userId;
        }
        float mon = Float.parseFloat(money);
        if (mon < 0){
            model.addAttribute("message", "直呼好家伙，自己扣自己的钱");
        }
        else{
            List<User> users = userService.checkPasswordValid(userId, password);
            if (users.isEmpty()){
                model.addAttribute("message", "密码错误");
            }
            else{
                model.addAttribute("message", "充钱成功");
                moneyService.insertMoney(userId, Float.parseFloat(money));
            }
        }
        model.addAttribute("message", "");
        return "redirect:/user/" + userId;
    }
}