package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.DTO.UserInfoDTO;
import com.LiteTravel.web.Model.User;
import com.LiteTravel.web.Model.UserExample;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.Model.UserInfoExample;
import com.LiteTravel.web.mapper.UserInfoMapper;
import com.LiteTravel.web.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    public List<User> checkUserValid(String userCode, String userPassword){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserCodeEqualTo(userCode)
                .andUserPasswordEqualTo(userPassword)
                .andUserStateEqualTo(1);
        return userMapper.selectByExample(userExample);
    }
    public UserInfo selectInfoByUserId(Integer userId){
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }
    public void insert(UserInfo info) {
        userInfoMapper.insert(info);
    }
    @Cacheable("users")
    public List<User> selectByCode(String userCode) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserCodeEqualTo(userCode);
        return userMapper.selectByExample(userExample);
    }

    public void updateInfo(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

//    修改用户信息
    public int modifyInfo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        System.out.println(userInfoDTO);
        int id =  userInfoMapper.updateByPrimaryKeySelective(userInfo);
//        System.out.println(id);
        return id;
    }
}
