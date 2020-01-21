package com.travelplatform.web.controller;

import com.travelplatform.web.mapper.UserInfoMapper;
import com.travelplatform.web.po.User;
import com.travelplatform.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;
@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("userCode") String userCode,
                        @RequestParam("userPassword") String userPassword,
                        Map<String, Object> map,
                        HttpSession session){
        User user = userMapper.findUser(userCode, userPassword);
        if(!StringUtils.isEmpty(userCode) && user != null){
            //获取用户信息
            session.setAttribute("loginUser",
                    userInfoMapper.findInfoById(user.getUserId()).getUsername());
            //需要重定向
            return "redirect:/index.html";
        }
        else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String register(@RequestParam("userCode") String userCode,
                           @RequestParam("userName") String userName,
                           @RequestParam("userPassword") String userPassword,
                           Map<String, Object> map,
                           HttpSession session) throws Exception {
        /*
         * 此处需要检查注册合理性，重名，重账号等
         * */
        InsertUser(userCode, userName, userPassword);
        if(userMapper.findUserByCode(userCode) != null) {
            login(userCode, userPassword, map, session);
            return "redirect:/main.html";
        }
        else {
            return "register";
        }
    }

    @Transactional
    public void InsertUser(String userCode, String userName, String userPassword) {
        userMapper.insertUser(userCode, userPassword);
        userInfoMapper.insertInfo(userMapper.findUserByCode(userCode).getUserId(), userName);
    }

    @GetMapping(value = "/toRegister")
    public String toRegister(){
        return "/register";
    }

    @GetMapping("/toLogin")
    public String toLogin(){ return "login"; }


}
