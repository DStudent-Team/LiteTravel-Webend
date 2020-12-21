package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.userMoney;
import com.LiteTravel.web.Model.userMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userMoneyMapper {
    long countByExample(userMoneyExample example);

    int deleteByExample(userMoneyExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(userMoney record);

    int insertSelective(userMoney record);

    List<userMoney> selectByExample(userMoneyExample example);

    userMoney selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") userMoney record, @Param("example") userMoneyExample example);

    int updateByExample(@Param("record") userMoney record, @Param("example") userMoneyExample example);

    int updateByPrimaryKeySelective(userMoney record);

    int updateByPrimaryKey(userMoney record);
}