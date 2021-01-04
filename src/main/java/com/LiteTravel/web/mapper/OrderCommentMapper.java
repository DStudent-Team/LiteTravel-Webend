package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.OrderComment;
import com.LiteTravel.web.Model.OrderCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCommentMapper {
    long countByExample(OrderCommentExample example);

    int deleteByExample(OrderCommentExample example);

    int deleteByPrimaryKey(Integer ocId);

    int insert(OrderComment record);

    int insertSelective(OrderComment record);

    List<OrderComment> selectByExample(OrderCommentExample example);

    OrderComment selectByPrimaryKey(Integer ocId);

    int updateByExampleSelective(@Param("record") OrderComment record, @Param("example") OrderCommentExample example);

    int updateByExample(@Param("record") OrderComment record, @Param("example") OrderCommentExample example);

    int updateByPrimaryKeySelective(OrderComment record);

    int updateByPrimaryKey(OrderComment record);
}