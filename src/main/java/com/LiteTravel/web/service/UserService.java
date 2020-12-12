package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.DTO.UserInfoDTO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.UserInfoMapper;
import com.LiteTravel.web.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    private ResultVO selectByExample(Integer page, Integer pageSize, UserExample userExample) {
        /* 分页：
         * 参数1: 第几页
         * 参数2: 每页展示几个数据 */
        PageHelper.startPage(page, pageSize);
        List<User> userList = userMapper.selectByExample(userExample);
        System.out.println(userList);
        PageInfo<User> info = new PageInfo<>(userList, 5);
        return new ResultVO(userList, info);
    }
}
