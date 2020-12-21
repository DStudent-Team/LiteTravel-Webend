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
import sun.plugin2.message.Message;

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

    /*后台添加用户信息*/
    @PostMapping("/manage/user")
    public String insertUser(UserManageDTO userManageDTO,
                             Map<String, Object> map){
        String userCode = userManageDTO.getUserCode();
        List<User> userList = userService.selectByCode(userCode);
        if(userList.size() > 0){
            map.put("msg","账号已存在！");
            System.out.println("账号已存在！");
            return "redirect:/manage/users";
        }else{
            userService.addUserByManager(userManageDTO,"insert");
        }
        return "redirect:/manage/users";
    }

    /*更新用户信息*/
    @PutMapping("manage/user")
    public String updateUser(UserManageDTO userManageDTO,
                             Map<String, Object> map){
        String userCode = userManageDTO.getUserCode();
        String userPassword = userManageDTO.getUserPassword();
        String userName = userManageDTO.getUserName();
        System.out.println(userCode);
        System.out.println(userPassword);
        System.out.println(userName);
        if(StringUtils.isAllBlank(userCode) || StringUtils.isAllBlank(userPassword) || StringUtils.isAllBlank(userName)){
            map.put("msg","账号、密码、昵称不能为空！");
            System.out.println("账号、密码、昵称不能为空！");
            return "redirect:/manage/users";
        }else {
            userService.addUserByManager(userManageDTO, "update");
        }
        return "redirect:/manage/users";
    }

    /*删除用户信息*/
    @PostMapping("manage/deleteUser")
    public String deleteUser(User user, Map<String, Object> map){
        int id = userService.deleteUser(user.getUserId());
        if(id == 1){
            return "redirect:/manage/users";
        }else{
            map.put("msg","删除失败！");
            return "redirect:/manage/users";
        }
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