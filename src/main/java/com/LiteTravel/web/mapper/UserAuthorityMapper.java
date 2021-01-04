package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.UserAuthority;
import com.LiteTravel.web.Model.UserAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAuthorityMapper {
    long countByExample(UserAuthorityExample example);

    int deleteByExample(UserAuthorityExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);

    List<UserAuthority> selectByExample(UserAuthorityExample example);

    UserAuthority selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserAuthority record, @Param("example") UserAuthorityExample example);

    int updateByExample(@Param("record") UserAuthority record, @Param("example") UserAuthorityExample example);

    int updateByPrimaryKeySelective(UserAuthority record);

    int updateByPrimaryKey(UserAuthority record);
}