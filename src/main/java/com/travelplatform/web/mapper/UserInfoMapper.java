package com.travelplatform.web.mapper;

import com.travelplatform.web.po.UserInfo;

public interface UserInfoMapper {
    public void insertInfo(UserInfo userInfo);
    public UserInfo findInfoById(Integer userId);
}
