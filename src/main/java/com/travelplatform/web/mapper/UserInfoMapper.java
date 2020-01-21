package com.travelplatform.web.mapper;

import com.travelplatform.web.po.UserInfo;

public interface UserInfoMapper {
    public void insertInfo(Integer id, String userName);
    public UserInfo findInfoById(Integer id);
}
