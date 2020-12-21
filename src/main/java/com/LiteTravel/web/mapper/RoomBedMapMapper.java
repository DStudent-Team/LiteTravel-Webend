package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.RoomBedMap;
import com.LiteTravel.web.Model.RoomBedMapExample;
import com.LiteTravel.web.Model.RoomBedMapKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomBedMapMapper {
    long countByExample(RoomBedMapExample example);

    int deleteByExample(RoomBedMapExample example);

    int deleteByPrimaryKey(RoomBedMapKey key);

    int insert(RoomBedMap record);

    int insertSelective(RoomBedMap record);

    List<RoomBedMap> selectByExample(RoomBedMapExample example);

    RoomBedMap selectByPrimaryKey(RoomBedMapKey key);

    int updateByExampleSelective(@Param("record") RoomBedMap record, @Param("example") RoomBedMapExample example);

    int updateByExample(@Param("record") RoomBedMap record, @Param("example") RoomBedMapExample example);

    int updateByPrimaryKeySelective(RoomBedMap record);

    int updateByPrimaryKey(RoomBedMap record);
}