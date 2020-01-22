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
    public String checkName(@RequestParam("userCode") String userCode) {
        String msg;
        System.out.println("Send In! :" + userCode);//没有找到userCode
        //根据用户名查询是否存在该用户名
        User user = userMapper.findUserByCode(userCode);
        //当对象不为空，说明用户名存在
        if(userCode != null && user == null) {
            msg = "{\"msg\":\"true\"}";
        }
        else {
            msg = "{\"msg\":\"false\"}";
        }
        System.out.println(msg);
        return msg;
    }

}
