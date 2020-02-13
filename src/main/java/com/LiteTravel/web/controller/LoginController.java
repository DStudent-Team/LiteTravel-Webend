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
                        @RequestParam("userPassword") String userPassword,
                        Map<String, Object> map,
                        HttpSession session){
        User user = userMapper.findUser(userCode, userPassword);
        if(!StringUtils.isEmpty(userCode) && user != null) {
            //获取用户信息
            Integer userId = user.getUserId();
            session.setAttribute("userId",
                    userId);
            session.setAttribute("userName",
                    userInfoMapper.findInfoById(userId).getUserName());
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
                           @RequestParam(name = "userName") String userName,
                           @RequestParam(name = "userPassword") String userPassword,
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
        user.setUserPassword(userPassword);
        userMapper.insertUser(user);
        System.out.println(user.getUserId());
        UserInfo userinfo = new UserInfo();
        userinfo.setUserId(user.getUserId());
        userinfo.setUserName(userName);
        userInfoMapper.insertInfo(userinfo);
        if(userMapper.findUserByCode(userCode) != null) {
            login(userCode, userPassword, map, session);
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


    @ResponseBody//返回给jsp字符串格式
    @PostMapping(value = "/checkName")
    public String checkName(@RequestParam("userCode") String userCode) {
        String msg;
        //根据用户名查询是否存在该用户名
        User user = userMapper.findUserByCode(userCode);
        //当对象不为空，说明用户名存在
        if(userCode != null && user == null) {
            msg = "{\"msg\":\"true\"}";
        }
        else {
            msg = "{\"msg\":\"false\"}";
        }
        return msg;
    }
}
