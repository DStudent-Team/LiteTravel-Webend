package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.HotelOrderQueryDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//@Service
public class HotelOrderSearchService {

    @Autowired
    public HotelMapper hotelMapper;

    @Autowired
    public HotelOrderMapper hotelOrderMapper;

    @Autowired
    public RoomMapper roomMapper;

    @Autowired
    public RoomBedMapMapper roomBedMapper;

    @Autowired
    public BedMapper bedMapper;

    @Autowired
    public RegionMapper regionMapper;

    @Autowired
    public HotelOrderService hotelOrderService;
//
//    public ResultVO getOrders(Integer page, Integer pageSize, HotelOrderQueryDTO hotelOrderQueryDTO) {
//        return hotelOrderService.selectByExample(page, pageSize, getHotelOrderExample(hotelOrderQueryDTO));
//    }
//
//    private HotelOrderExample getHotelOrderExample(HotelOrderQueryDTO query) {
//
//        //获取查询条件
//        Integer userId = query.getUserId();
//        String hotelName = query.getKeyword();
//        Date startTime = query.getStartTime();
//        Date endTime = query.getEndTime();
//        List<String> status = query.getStatus();
//        Integer hotelAddress = query.getHotelAddress();
//
//        HotelOrderExample hotelOrderExample = new HotelOrderExample();
//        HotelExample hotelExample = new HotelExample();
//        HotelExample.Criteria hotelExampleCriteria = hotelExample.createCriteria();
//
//        HotelOrderExample.Criteria hotelOrderExampleCriteria = hotelOrderExample.createCriteria();
//        if (hotelName != null) {
//            hotelExampleCriteria.andHotelNameLike(hotelName);
//        }
//        /*这个通过数字代码范围来查询我也不确定行不行, 总之试试看*/
//        if (hotelAddress != null) {
//            int regionId = hotelAddress / 100;
//            /*范围查询*/
//            hotelExampleCriteria.andHotelAddressBetween(regionId * 100, regionId * 100 + 99);
//        }
//        List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);
//        List<Integer> hotelIds = hotels.stream().map(Hotel::getHotelId).distinct().collect(Collectors.toList());
//        if (userId != null) {
//            hotelOrderExampleCriteria.andUserIdEqualTo(userId);
//        }
//        //根据起止时间和订单状态找到订单
//        if (startTime != null){
//            hotelOrderExampleCriteria.andCreateDateGreaterThanOrEqualTo(startTime);
//        }
//        if (endTime != null)
//        {
//            hotelOrderExampleCriteria.andCreateDateLessThanOrEqualTo(endTime);
//
//        }
//        if (status != null && status.size() > 0) {
//            hotelOrderExampleCriteria.andStatusIn(status);
//        }
//        hotelIds.add(-1);// 防止example生成空hotel报错, 加上这一条并不会影响查询到错误的结果
//        hotelOrderExampleCriteria.andHotelIdIn(hotelIds);
//        return hotelOrderExample;
//    }
}