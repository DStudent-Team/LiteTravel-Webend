package com.travelplatform.web.mapper;

import com.travelplatform.web.po.User;

public interface UserMapper {
    public User findUser(String userCode, String userPassword);
    public void insertUser(String userCode, String userPassword);
    public User findUserByCode(String userCode);
}
