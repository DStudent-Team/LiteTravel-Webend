package com.travelplatform.web.controller;

import com.travelplatform.web.mapper.UserInfoMapper;
import com.travelplatform.web.po.User;
import com.travelplatform.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session){
        User user = userMapper.findUser(userCode, password);
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

    @Transactional
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String register(@RequestParam(name = "userCode") String userCode,
                           @RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password,
                           Map<String, Object> map,
                           HttpSession session) throws Exception {
        /*
         * 此处需要检查注册合理性，重名，重账号等
         * */
        if(userMapper.findUserByCode(userCode) != null)
            return "register";
        userMapper.insertUser(userCode, password);
        userInfoMapper.insertInfo(userMapper.findUserByCode(userCode).getUserId(), username);
        if(userMapper.findUserByCode(userCode) != null) {
            login(userCode, password, map, session);
            return "redirect:/index.html";
        }
        else {
            return "register";
        }
    }

    @GetMapping(value = "/toRegister")
    public String toRegister(){
        return "/register";
    }

    @GetMapping("/toLogin")
    public String toLogin(){ return "login"; }


}
