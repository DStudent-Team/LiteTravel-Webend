package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.HotelOrderQueryCriteriaDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SearchService {

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

    public ResultVO getOrders(Integer page, Integer pageSize, Integer userId, HotelOrderQueryCriteriaDTO hotelOrderQueryCriteriaDTO) throws ParseException {
        return hotelOrderService.selectByExample(page, pageSize, selectOrderByMulti(userId,hotelOrderQueryCriteriaDTO));
    }

    public HotelOrderExample selectOrderByMulti(Integer userId, HotelOrderQueryCriteriaDTO hotelOrderQueryCriteriaDTO) throws ParseException {

        //获取查询条件
        String hotelName = hotelOrderQueryCriteriaDTO.getHotelName();
        String startTime = hotelOrderQueryCriteriaDTO.getStartTime();
        String endTime = hotelOrderQueryCriteriaDTO.getEndTime();
        List<String> status = hotelOrderQueryCriteriaDTO.getStatus();
        String hotelAddress = hotelOrderQueryCriteriaDTO.getHotelAddress();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        HotelOrderExample hotelOrderExample = new HotelOrderExample();
        HotelExample hotelExample = new HotelExample();

        System.out.println(hotelOrderQueryCriteriaDTO.toString());
        if (hotelName != null) {

            hotelName = "%" + hotelName + "%";
            if (hotelAddress != null) {
                RegionExample regionExample = new RegionExample();
                regionExample.createCriteria()
                        .andMernameEqualTo(hotelAddress);
                //取地址id前4位
                int regionId = regionMapper.selectByExample(regionExample).get(0).getId() / 100;

                hotelExample.createCriteria()
                        .andHotelNameLike(hotelName)
                        .andHotelAddressBetween(regionId * 100, regionId * 100 + 99);
            } else {
                hotelExample.createCriteria()
                        .andHotelNameLike(hotelName);
            }
        } else if (hotelAddress != null) {

            RegionExample regionExample = new RegionExample();
            regionExample.createCriteria()
                    .andMernameEqualTo(hotelAddress);
            //取地址id前4位
            int regionId = regionMapper.selectByExample(regionExample).get(0).getId() / 100;
            hotelExample = new HotelExample();
            hotelExample.createCriteria()
                    .andHotelAddressBetween(regionId * 100, regionId * 100 + 99);
        }

        List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);
        List<Integer> hotelIds = new ArrayList<>();
        for (Hotel hotel: hotels) {
            hotelIds.add(hotel.getHotelId());
        }

        //根据起止时间和订单状态找到订单
        if (startTime != null && endTime != null) {

            if (status != null && status.size() > 0) {

                hotelOrderExample.createCriteria()
                        .andUserIdEqualTo(userId)
                        .andCreateDateBetween(formatter.parse(startTime), new Date(formatter.parse(endTime).getTime() + (60*60*24-1)*1000))
                        .andStatusIn(status)
                        .andHotelIdIn(hotelIds);

            } else {
                hotelOrderExample.createCriteria()
                        .andUserIdEqualTo(userId)
                        .andCreateDateBetween(formatter.parse(startTime), new Date(formatter.parse(endTime).getTime() + (60*60*24-1)*1000))
                        .andHotelIdIn(hotelIds);
            }
        } else if (status != null && status.size() > 0) {
            hotelOrderExample.createCriteria()
                    .andUserIdEqualTo(userId)
                    .andStatusIn(status)
                    .andHotelIdIn(hotelIds);
        } else {
            hotelOrderExample.createCriteria()
                    .andUserIdEqualTo(userId)
                    .andHotelIdIn(hotelIds);
        }
        return hotelOrderExample;
    }
}