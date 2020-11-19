package com.LiteTravel.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface HotelExtMapper {

    public void incReplyCount(Integer hotelReplyLevel, Integer hotelReplyCount);
}
