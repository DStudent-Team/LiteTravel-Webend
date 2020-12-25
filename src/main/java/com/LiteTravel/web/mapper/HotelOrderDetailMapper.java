package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.HotelOrderDetail;
import com.LiteTravel.web.Model.HotelOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelOrderDetailMapper {
    long countByExample(HotelOrderDetailExample example);

    int deleteByExample(HotelOrderDetailExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(HotelOrderDetail record);

    int insertSelective(HotelOrderDetail record);

    List<HotelOrderDetail> selectByExample(HotelOrderDetailExample example);

    HotelOrderDetail selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") HotelOrderDetail record, @Param("example") HotelOrderDetailExample example);

    int updateByExample(@Param("record") HotelOrderDetail record, @Param("example") HotelOrderDetailExample example);

    int updateByPrimaryKeySelective(HotelOrderDetail record);

    int updateByPrimaryKey(HotelOrderDetail record);
}