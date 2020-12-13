package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.Model.User;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestParam("userCode") String userCode,
                        @RequestParam("userPassword") String userPassword,
                        Map<String, Object> map,
                        HttpSession session){
        /* Mybatis Generator 生成的筛选条件器 */
        List<User> users = userService.checkUserValid(userCode, userPassword);
        if(!StringUtils.isEmpty(userCode) && users.size() != 0) {
            // 获取用户信息
            UserInfo userInfo = userService.selectInfoByUserId(users.get(0).getUserId());
            // 写入数据至前端页面
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(userInfo.getUserId());
            userDTO.setUserName(userInfo.getUserName());
            userDTO.setUserAvatarUri(userInfo.getUserAvatarUri());
            session.setAttribute("user", userDTO);

            //需要重定向
            return "redirect:index";
        }
        else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

    @Transactional
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(name = "userCode") String userCode,
                           @RequestParam(name = "userName") String userName,
                           @RequestParam(name = "userPassword") String userPassword,
                           Map<String, Object> map,
                           HttpSession session) throws Exception {
        /*
         * 此处需要检查注册合理性，重名，重账号等
         * 重账号用js直接Post请求完成
         * */
//        设置筛选条件 : userCode
        if(userService.selectByCode(userCode).size() != 0)
            return "redirect:/toRegister";
        User user = new User();
//        写入账号密码
        user.setUserCode(userCode);
        user.setUserPassword(userPassword);
        user.setUserState(1);
        userService.insert(user);
//        写入账号信息
        UserInfo userinfo = new UserInfo();
        userinfo.setUserId(user.getUserId());
        userinfo.setUserName(userName);
//        设置信息初始化值
        userinfo.setUserGender(0);
        userinfo.setUserBirth(new Date());
        userinfo.setUserAvatarUri("avatar.jpg");
        userService.insert(userinfo);
//        自动跳转登陆
        if(userService.selectByCode(userCode).size() != 0) {
            login(userCode, userPassword, map, session);
            return "redirect:/index";
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


    @ResponseBody//返回给jsp 字符串/json 格式
    @PostMapping(value = "/checkName")
    public String checkName(@RequestParam("userCode") String userCode) {
        String msg;
        //根据用户名查询是否存在该用户名
        List<User> users = userService.selectByCode(userCode);
        //当对象不为空，说明用户名存在
        if(userCode != null && users.size() != 0)
        {
            msg = "{\"msg\":\"true\"}";
        }
        else
        {
            msg = "{\"msg\":\"false\"}";
        }
        return msg;
    }
}
