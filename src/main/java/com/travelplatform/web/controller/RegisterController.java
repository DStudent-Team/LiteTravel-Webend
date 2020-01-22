package com.travelplatform.web.controller;

import com.travelplatform.web.po.User;
import com.travelplatform.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    UserMapper userMapper;

    @ResponseBody//返回给jsp字符串格式
    @PostMapping(value = "/checkName")
    public String checkName(String userCode) {
        String msg;
        System.out.println("Send In! :" + userCode);
        //根据用户名查询是否存在该用户名
        User user = userMapper.findUserByCode(userCode);
        //当对象不为空，说明用户名存在
        if(user != null) {
            msg = "{\"msg\":\"false\"}";
        }
        else {
            msg = "{\"msg\":\"true\"}";
        }
        System.out.println(msg);
        return msg;
    }

}
