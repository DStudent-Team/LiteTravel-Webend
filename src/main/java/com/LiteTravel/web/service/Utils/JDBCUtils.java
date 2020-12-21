package com.LiteTravel.web.service.Utils;

import com.LiteTravel.web.DTO.HotelDTO;
import com.LiteTravel.web.DTO.RoomDTO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.HotelOrderDetailMapper;
import com.LiteTravel.web.mapper.HotelOrderMapper;
import com.LiteTravel.web.mapper.RegionMapper;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JDBCUtils {
    /*通过regionMapper 基于 地址字符串 查询 地址Id*/
    public static int getSecondaryRegionId(RegionMapper regionMapper, String regionString){
        /*这个通过数字代码范围来查询我也不确定行不行, 总之试试看*/
        if (regionString != null && regionString.length() > 0) {
            RegionExample regionExample = new RegionExample();
            //格式化地址选择器传来的地址信息，只取城市
            regionString = regionString.split("/")[1];
            regionExample.createCriteria().andNameLike("%" + regionString + "%");

            //获取4位地址id，通过范围选择包括下面的区县
            return regionMapper.selectByExample(regionExample).get(0).getId() / 100 * 100;
        }
        else {
            return -1;
        }
    }

    /***
     * 获得房间被预定数
     * @param hotelOrderMapper
     * @param hotelOrderDetailMapper
     * @param hotelId
     * @param roomIds
     * @param from
     * @param to
     * @return
     */
    public static Map<Integer, Integer> getRoomReserved(HotelOrderMapper hotelOrderMapper, HotelOrderDetailMapper hotelOrderDetailMapper, Integer hotelId, List<Integer> roomIds, Date from, Date to){
        HotelOrderExample droppedOrderExample = new HotelOrderExample();
        HotelOrderExample.Criteria checkOut = droppedOrderExample.createCriteria()
                .andCheckOutLessThanOrEqualTo(from);
        HotelOrderExample.Criteria checkIn = droppedOrderExample.createCriteria()
                .andCheckInGreaterThanOrEqualTo(to);
        droppedOrderExample.or(checkOut);
        droppedOrderExample.or(checkIn);
        List<HotelOrder> droppedOrders = hotelOrderMapper.selectByExample(droppedOrderExample);
        List<Integer> droppedIds = droppedOrders.stream().map(HotelOrder::getOrderId).distinct().collect(Collectors.toList());
        HotelOrderExample wantedOrderExample = new HotelOrderExample();
        wantedOrderExample.createCriteria()
                .andHotelIdEqualTo(hotelId)
                .andOrderIdNotIn(droppedIds);
        List<HotelOrder> wantedOrders = hotelOrderMapper.selectByExample(wantedOrderExample);
        List<Integer> wantIds = wantedOrders.stream().map(HotelOrder::getOrderId).distinct().collect(Collectors.toList());
        HotelOrderDetailExample hotelOrderDetailExample = new HotelOrderDetailExample();
        hotelOrderDetailExample.createCriteria()
                .andOrderIdIn(wantIds)
                .andRoomIdIn(roomIds);
        List<HotelOrderDetail> hotelOrderDetails = hotelOrderDetailMapper.selectByExample(hotelOrderDetailExample);
        return RoomCountMapMerge(hotelOrderDetails, 0);
    }

    private static Map<Integer, Integer> RoomCountMapMerge(List<HotelOrderDetail> hotelOrderDetails, Integer method){
        if (method == 0){
            /*第一种计算总预订数的方法*/
            Map<Integer, Integer> roomCountMap = new HashMap<>();
            hotelOrderDetails.forEach(hotelOrderDetail -> {
                Integer roomId = hotelOrderDetail.getRoomId();
                Integer roomCount = hotelOrderDetail.getRoomCount();
                roomCountMap.merge(roomId, roomCount, Integer::sum);
            });
            return roomCountMap;
        }
        else {
            /*第二种计算总预订数的方法 更精简的写法, 未测试哪个好用*/
            return hotelOrderDetails.stream().collect(Collectors.toMap(HotelOrderDetail::getRoomId, HotelOrderDetail::getRoomCount, Integer::sum));
        }
    }
    /*初始化酒店DTO*/
    public static HotelDTO initHotelDTO(RegionMapper regionMapper, Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        BeanUtils.copyProperties(hotel, hotelDTO);
        RegionExample regionExample = new RegionExample();
        regionExample.createCriteria()
                .andIdEqualTo(hotel.getHotelAddress());
        List<Region> regions = regionMapper.selectByExample(regionExample);
        if(regions.size() > 0){
            hotelDTO.setHotelAddressString(regions.get(0).getMername());
        }
        return hotelDTO;
    }

}
