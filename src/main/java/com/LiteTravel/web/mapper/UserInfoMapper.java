package com.LiteTravel.web.mapper;

import com.LiteTravel.web.po.UserInfo;

public interface UserInfoMapper {
    public void insertInfo(UserInfo userInfo);
    public UserInfo findInfoById(Integer userId);
    public void updateUserInfo(UserInfo userInfo);
}
