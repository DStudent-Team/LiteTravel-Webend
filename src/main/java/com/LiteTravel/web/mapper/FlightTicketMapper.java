package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.FlightTicket;
import com.LiteTravel.web.Model.FlightTicketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlightTicketMapper {
    long countByExample(FlightTicketExample example);

    int deleteByExample(FlightTicketExample example);

    int deleteByPrimaryKey(Integer ticketId);

    int insert(FlightTicket record);

    int insertSelective(FlightTicket record);

    List<FlightTicket> selectByExample(FlightTicketExample example);

    FlightTicket selectByPrimaryKey(Integer ticketId);

    int updateByExampleSelective(@Param("record") FlightTicket record, @Param("example") FlightTicketExample example);

    int updateByExample(@Param("record") FlightTicket record, @Param("example") FlightTicketExample example);

    int updateByPrimaryKeySelective(FlightTicket record);

    int updateByPrimaryKey(FlightTicket record);
}