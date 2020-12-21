package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.transaction;
import com.LiteTravel.web.Model.transactionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface transactionMapper {
    long countByExample(transactionExample example);

    int deleteByExample(transactionExample example);

    int deleteByPrimaryKey(Integer transactionId);

    int insert(transaction record);

    int insertSelective(transaction record);

    List<transaction> selectByExample(transactionExample example);

    transaction selectByPrimaryKey(Integer transactionId);

    int updateByExampleSelective(@Param("record") transaction record, @Param("example") transactionExample example);

    int updateByExample(@Param("record") transaction record, @Param("example") transactionExample example);

    int updateByPrimaryKeySelective(transaction record);

    int updateByPrimaryKey(transaction record);
}