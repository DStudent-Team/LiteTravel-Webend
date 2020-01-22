package com.travelplatform.web.mapper;

import com.travelplatform.web.po.UserInfo;

public interface UserInfoMapper {
    public void insertInfo(Integer userId, String username);
    public UserInfo findInfoById(Integer userId);
}
