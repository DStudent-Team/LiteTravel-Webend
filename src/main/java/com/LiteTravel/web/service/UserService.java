package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.UserInfoMapper;
import com.LiteTravel.web.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public ResultVO getUsers(Integer page, Integer pageSize){
        return selectByExample(page, pageSize, new UserInfoExample());
    }

    private ResultVO selectByExample(Integer page, Integer pageSize, UserInfoExample userInfoExample) {
        /* 分页：
         * 参数1: 第几页
         * 参数2: 每页展示几个数据 */
        PageHelper.startPage(page, pageSize);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        PageInfo<UserInfo> info = new PageInfo<>(userInfos, 5);
//        System.out.println(userList);
        List<Integer> userIds = userInfos.stream().map(UserInfo::getUserId).distinct().collect(Collectors.toList());
        Map<Integer, String> userCodeMap;
        Map<Integer, String> userPasswordMap;
        Map<Integer, Integer> userStateMap;
        if(userIds.size() > 0){
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andUserIdIn(userIds);
            List<User> users = userMapper.selectByExample(userExample);
            userCodeMap = users.stream().collect(Collectors.toMap(User::getUserId, User::getUserCode));
            userPasswordMap = users.stream().collect(Collectors.toMap(User::getUserId, User::getUserPassword));
            userStateMap = users.stream().collect(Collectors.toMap(User::getUserId, User::getUserState));
        }else {
            userCodeMap = new HashMap<>();
            userPasswordMap = new HashMap<>();
            userStateMap = new HashMap<>();
        }
        List<UserManageDTO> data = userInfos.stream().map(userInfo -> {
            UserManageDTO userManageDTO = new UserManageDTO();
            BeanUtils.copyProperties(userInfo, userManageDTO);
            String userCode = userCodeMap.get(userInfo.getUserId());
            String userPassword = userPasswordMap.get(userInfo.getUserId());
            Integer userState = userStateMap.get(userInfo.getUserId());
            userManageDTO.setUserCode(userCode);
            userManageDTO.setUserPassword(userPassword);
            userManageDTO.setUserState(userState);
            return userManageDTO;
        }).collect(Collectors.toList());
        return new ResultVO(data, info);
    }


}
