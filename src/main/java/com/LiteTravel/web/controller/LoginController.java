package com.LiteTravel.web.controller;

import com.LiteTravel.web.mapper.UserInfoMapper;
import com.LiteTravel.web.po.User;
import com.LiteTravel.web.po.UserInfo;
import com.LiteTravel.web.mapper.UserMapper;
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
        if(!StringUtils.isEmpty(userCode) && user != null) {
            //获取用户信息
            Integer userId = user.getUserId();
            session.setAttribute("userId",
                    userId);
            session.setAttribute("username",
                    userInfoMapper.findInfoById(userId).getUsername());
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
         * 重账号用js直接Post请求完成
         * */
        if(userMapper.findUserByCode(userCode) != null)
            return "redirect:/toRegister";
        User user = new User();
        user.setUserCode(userCode);
        user.setPassword(password);
        userMapper.insertUser(user);
        System.out.println(user.getUserId());
        UserInfo userinfo = new UserInfo();
        userinfo.setUserId(user.getUserId());
        userinfo.setUsername(username);
        userInfoMapper.insertInfo(userinfo);
        if(userMapper.findUserByCode(userCode) != null) {
            login(userCode, password, map, session);
            return "redirect:/index.html";
        }
        else {
            return "redirect:/toRegister";
        }
    }

    @GetMapping(value = "/toRegister")
    public String toRegister(){
        return "register";
    }

    @GetMapping("/toLogin")
    public String toLogin(){ return "login"; }

}
