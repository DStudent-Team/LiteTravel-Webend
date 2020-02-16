package com.LiteTravel.web.service;

import com.LiteTravel.web.Model.HotelExample;
import com.LiteTravel.web.mapper.HotelMapper;
import com.LiteTravel.web.Model.Hotel;
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
        return hotelMapper.selectByExampleWithBLOBs(new HotelExample());
    }

    @Cacheable(cacheNames = {"hotel"}, key = "#hotelId")
    public Hotel getHotelById(Integer hotelId){
        return hotelMapper.selectByPrimaryKey(hotelId);
    }

    @Cacheable(cacheNames = {"relateHotels"}, key = "#hotelId")
    public List<Hotel> getHotels(Integer hotelId, Integer page, Integer pageSize)
    {
        PageHelper.startPage(page, pageSize);
        HotelExample hotelExample = new HotelExample();
//      todo 推荐算法尚未写好
        hotelExample.createCriteria()
                .andHotelIdNotEqualTo(hotelId);
        return hotelMapper.selectByExampleWithBLOBs(hotelExample);
    }
}
