package com.LiteTravel.web.mapper;

import com.LiteTravel.web.po.Hotel;

import java.util.List;

public interface HotelMapper {
    public List<Hotel> getHotels();
    public Hotel getHotelById(Integer id);
    public List<Hotel> getHotelsByAddress(String address);
}
