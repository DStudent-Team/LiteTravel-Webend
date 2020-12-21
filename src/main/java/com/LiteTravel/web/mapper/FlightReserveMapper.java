package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.FlightReserve;
import com.LiteTravel.web.Model.FlightReserveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlightReserveMapper {
    long countByExample(FlightReserveExample example);

    int deleteByExample(FlightReserveExample example);

    int deleteByPrimaryKey(Integer reserveId);

    int insert(FlightReserve record);

    int insertSelective(FlightReserve record);

    List<FlightReserve> selectByExampleWithBLOBs(FlightReserveExample example);

    List<FlightReserve> selectByExample(FlightReserveExample example);

    FlightReserve selectByPrimaryKey(Integer reserveId);

    int updateByExampleSelective(@Param("record") FlightReserve record, @Param("example") FlightReserveExample example);

    int updateByExampleWithBLOBs(@Param("record") FlightReserve record, @Param("example") FlightReserveExample example);

    int updateByExample(@Param("record") FlightReserve record, @Param("example") FlightReserveExample example);

    int updateByPrimaryKeySelective(FlightReserve record);

    int updateByPrimaryKeyWithBLOBs(FlightReserve record);

    int updateByPrimaryKey(FlightReserve record);
}