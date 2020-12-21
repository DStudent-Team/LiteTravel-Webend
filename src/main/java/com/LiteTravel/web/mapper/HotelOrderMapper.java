package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.HotelOrder;
import com.LiteTravel.web.Model.HotelOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelOrderMapper {
    long countByExample(HotelOrderExample example);

    int deleteByExample(HotelOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(HotelOrder record);

    int insertSelective(HotelOrder record);

    List<HotelOrder> selectByExampleWithBLOBs(HotelOrderExample example);

    List<HotelOrder> selectByExample(HotelOrderExample example);

    HotelOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") HotelOrder record, @Param("example") HotelOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") HotelOrder record, @Param("example") HotelOrderExample example);

    int updateByExample(@Param("record") HotelOrder record, @Param("example") HotelOrderExample example);

    int updateByPrimaryKeySelective(HotelOrder record);

    int updateByPrimaryKeyWithBLOBs(HotelOrder record);

    int updateByPrimaryKey(HotelOrder record);
}