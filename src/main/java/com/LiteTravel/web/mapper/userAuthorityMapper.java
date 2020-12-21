package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.userAuthority;
import com.LiteTravel.web.Model.userAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userAuthorityMapper {
    long countByExample(userAuthorityExample example);

    int deleteByExample(userAuthorityExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(userAuthority record);

    int insertSelective(userAuthority record);

    List<userAuthority> selectByExample(userAuthorityExample example);

    userAuthority selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") userAuthority record, @Param("example") userAuthorityExample example);

    int updateByExample(@Param("record") userAuthority record, @Param("example") userAuthorityExample example);

    int updateByPrimaryKeySelective(userAuthority record);

    int updateByPrimaryKey(userAuthority record);
}