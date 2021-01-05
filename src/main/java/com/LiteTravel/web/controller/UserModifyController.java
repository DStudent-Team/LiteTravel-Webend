package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.DTO.UserInfoDTO;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserModifyController {
    @Resource
    UserService userService;

    //    修改用户信息
    @PostMapping("/user/modify")
    @Transactional
    public ResponseDTO modifyUserInfo(@RequestBody UserInfoDTO userInfoDTO){
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO,userInfo);
        int id = userService.modifyInfo(userInfoDTO);
        return ResponseDTO.success(id);
    }
}
