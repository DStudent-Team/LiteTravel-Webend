package com.travelplatform.web.mapper;

import com.travelplatform.web.po.Hotel;

import java.util.List;

public interface HotelMapper {
    public List<Hotel> getHotels();
    public Hotel getHotelById();
    public List<Hotel> getHotelsByPlace();
}
