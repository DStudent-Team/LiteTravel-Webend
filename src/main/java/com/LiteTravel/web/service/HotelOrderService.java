package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.HotelOrderDTO;
import com.LiteTravel.web.Model.HotelOrder;
import com.LiteTravel.web.Model.HotelOrderExample;
import com.LiteTravel.web.mapper.HotelOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class HotelOrderService {

    public HotelOrderMapper hotelOrderMapper;

    public List<HotelOrderDTO> selectAll(){
        return hotelOrderMapper.selectByExample(new HotelOrderExample()).stream().map(HotelOrder ->{
            HotelOrderDTO hotelOrderDTO = new HotelOrderDTO();
            BeanUtils.copyProperties(HotelOrder, hotelOrderDTO);
            return hotelOrderDTO;
        }).collect(Collectors.toList());
    }

    public HotelOrderDTO selectByOrderId(Integer orderId){
        HotelOrder hotelOrder = hotelOrderMapper.selectByPrimaryKey(orderId);
        HotelOrderDTO hotelOrderDTO = new HotelOrderDTO();
        BeanUtils.copyProperties(hotelOrder, hotelOrderDTO);
        return hotelOrderDTO;
    }


    public void insertHotelOrder(HotelOrder hotelOrder){
        hotelOrderMapper.insert(hotelOrder);
    }

}
