package com.LiteTravel.web.service;

import com.LiteTravel.web.mapper.HotelMapper;
import com.LiteTravel.web.po.Hotel;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    public HotelMapper hotelMapper;
    @Cacheable(cacheNames = {"hotels"}, key = "#page")
    public List<Hotel> getHotels(Integer page, Integer pageSize){
        /* 分页：
         * 参数1: 第几页
         * 参数2: 每页展示几个数据 */
        PageHelper.startPage(page, pageSize);
        List<Hotel> hotels = hotelMapper.getHotels();
        return hotels;
    }
    @Cacheable(cacheNames = {"hotel"}, key = "#hotelId")
    public Hotel getHotelById(Integer hotelId){
        Hotel hotel = hotelMapper.getHotelById(hotelId);
        return hotel;
    }
    @Cacheable(cacheNames = {"relateHotels"}, key = "#hotelId")
    public List<Hotel> getHotels(Integer hotelId, Integer page, Integer pageSize)
    {
        PageHelper.startPage(page, pageSize);
        List<Hotel> relatedHotels = hotelMapper.getRelatedHotel(hotelId);
        return relatedHotels;
    }

}
