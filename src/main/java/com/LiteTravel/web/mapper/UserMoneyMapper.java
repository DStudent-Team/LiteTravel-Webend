package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.UserMoney;
import com.LiteTravel.web.Model.UserMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMoneyMapper {
    long countByExample(UserMoneyExample example);

    int deleteByExample(UserMoneyExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserMoney record);

    int insertSelective(UserMoney record);

    List<UserMoney> selectByExample(UserMoneyExample example);

    UserMoney selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserMoney record, @Param("example") UserMoneyExample example);

    int updateByExample(@Param("record") UserMoney record, @Param("example") UserMoneyExample example);

    int updateByPrimaryKeySelective(UserMoney record);

    int updateByPrimaryKey(UserMoney record);
}