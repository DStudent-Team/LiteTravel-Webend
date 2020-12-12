package com.LiteTravel.web.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface HotelExtMapper {

    public void incReplyCount(Integer hotelReplyLevel, Integer hotelReplyCount);
}
