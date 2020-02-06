package com.LiteTravel.web.mapper;

import com.LiteTravel.web.po.User;

public interface UserMapper {
    public User findUser(String userCode, String password);
    public User findUserByCode(String userCode);
    public User findUserById(Integer userId);
    public void insertUser(User user);
}
