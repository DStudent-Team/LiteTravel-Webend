package com.travelplatform.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String Hello(){
        return "Hello from Quick Web Application";
    }

    @RequestMapping("/success")
    public String Success(Map<String, Object> map){
        map.put("hello", "你好");
        return "success";
    }
}
