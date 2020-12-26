package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.HotelManager;
import com.LiteTravel.web.Model.HotelManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelManagerMapper {
    long countByExample(HotelManagerExample example);

    int deleteByExample(HotelManagerExample example);

    int deleteByPrimaryKey(Integer hotelManagerId);

    int insert(HotelManager record);

    int insertSelective(HotelManager record);

    List<HotelManager> selectByExample(HotelManagerExample example);

    HotelManager selectByPrimaryKey(Integer hotelManagerId);

    int updateByExampleSelective(@Param("record") HotelManager record, @Param("example") HotelManagerExample example);

    int updateByExample(@Param("record") HotelManager record, @Param("example") HotelManagerExample example);

    int updateByPrimaryKeySelective(HotelManager record);

    int updateByPrimaryKey(HotelManager record);
}