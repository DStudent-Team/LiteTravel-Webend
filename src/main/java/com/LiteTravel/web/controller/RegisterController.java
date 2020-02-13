package com.LiteTravel.web.controller;

import com.LiteTravel.web.po.User;
import com.LiteTravel.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    UserMapper userMapper;



}
