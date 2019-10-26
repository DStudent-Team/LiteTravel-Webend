package com.travelplatform.web.controller;

import com.travelplatform.web.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;

//    @ResponseBody
//    @RequestMapping("/query")
//    public Map<String, Object> map() {
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
//        return list.get(0);
//    }
//
//    @ResponseBody
//    @RequestMapping("/hello")
//    public String Hello(@RequestParam("user") String user) {
//        if (user.equals("aaa")) {
//            throw new UserNotExistException();
//        }
//        return "Hello from Quick Web Application";
//
//    }
//
//    @RequestMapping("/success")
//    public String Success(Map<String, Object> map){
//        map.put("hello", "你好");
//        return "success";
//    }
}
