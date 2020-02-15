package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Hotel;

import java.util.List;

public interface HotelMapper {
    public List<Hotel> getHotels();
    public Hotel getHotelById(Integer hotelId);
    public List<Hotel> getHotelsByAddress(String hotelAddress);
    public List<Hotel> getRelatedHotel(Integer hotelId);
}
