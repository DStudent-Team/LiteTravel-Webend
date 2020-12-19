package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.Flight.FlightDTO;
import com.LiteTravel.web.DTO.Flight.FlightSearchDTO;
import com.LiteTravel.web.DTO.Flight.FlightTicketDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.FlightMapper;
import com.LiteTravel.web.mapper.FlightTicketMapper;
import com.LiteTravel.web.mapper.RegionMapper;
import com.LiteTravel.web.utils.CustomUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    FlightMapper flightMapper;
    @Autowired
    FlightTicketMapper flightTicketMapper;
    @Autowired
    RegionMapper regionMapper;


    public ResultVO getFlights(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Flight> flights = flightMapper.selectByExample(new FlightExample());
        PageInfo<Flight> info = new PageInfo<>(flights, 5);
        List<FlightDTO> data = flights.stream().map(flight -> getFlightDTO(flight, false)).collect(Collectors.toList());
        return new ResultVO(data, info);
    }

    public FlightDTO getFlightById(Integer flightId){
        Flight flight = flightMapper.selectByPrimaryKey(flightId);
        return getFlightDTO(flight,true);
    }
    private FlightDTO getFlightDTO(Flight flight, boolean ticketFlag){
        FlightDTO flightDTO = new FlightDTO();
        BeanUtils.copyProperties(flight, flightDTO);
        //地址名
        Region regionFrom = regionMapper.selectByPrimaryKey(flight.getFlightFrom());
        flightDTO.setFlightFromString(regionFrom.getName());
        Region regionTo = regionMapper.selectByPrimaryKey(flight.getFlightTo());
        flightDTO.setFlightToString(regionTo.getName());
        //服务商提供的航班服务信息
        if (flight.getFlightStatus() >= 1 && ticketFlag){
            
//            FlightTicketExample flightTicketExample = new FlightTicketExample();
//            flightTicketExample.createCriteria()
//                    .andFlightIdEqualTo(flight.getFlightId());
//            List<FlightTicket> flightTickets = flightTicketMapper.selectByExample(flightTicketExample);
//            if (flightTickets.size() > 0){
//                flightDTO.setFlightTickets(flightTickets.stream().map(flightTicket -> {
//                    FlightTicketDTO flightTicketDTO = new FlightTicketDTO();
//                    BeanUtils.copyProperties(flightTicket, flightTicketDTO);
//                    return flightTicketDTO;
//                }).collect(Collectors.toList()));
//            }
        }
        return flightDTO;
    }

    public Integer submitFlight(FlightDTO flightDTO){
        Flight flight = new Flight();
        flightDTO.setFlightFrom(getSecondaryRegionId(flightDTO.getFlightFromString()));
        flightDTO.setFlightTo(getSecondaryRegionId(flightDTO.getFlightToString()));
        BeanUtils.copyProperties(flightDTO, flight);
        flight.setFlightStatus(0);
        flightMapper.insert(flight);
        return flight.getFlightId();
    }

    public void payFlight(Integer flightId) {
        Flight flight = new Flight();
        flight.setFlightId(flightId);
        flight.setFlightStatus(2);
        flightMapper.updateByPrimaryKeySelective(flight);
    }

    public double evaluateOrder(FlightDTO flightDTO) {
        Region fromRegion = regionMapper.selectByPrimaryKey(flightDTO.getFlightFrom());
        Region toRegion = regionMapper.selectByPrimaryKey(flightDTO.getFlightTo());
        if (fromRegion == null || toRegion == null){
            return -1;
        }
        Float fromLat = fromRegion.getLat();
        Float fromLng = fromRegion.getLng();
        Float toLat = toRegion.getLat();
        Float toLng = toRegion.getLng();
        double distance = CustomUtils.getDistance(fromLat, fromLng, toLat, toLng);

        Integer seats = flightDTO.getFlightSeats();
        Integer level = flightDTO.getFlightLevel();
        Date depart = flightDTO.getFlightDepart();
        Date arrived = flightDTO.getFlightArrived();
        float dayDiff;
        if (depart != null){
            dayDiff = CustomUtils.getDayDiff(new Date(), depart) + 0.1f;
        }
        else if (arrived != null){
            dayDiff = CustomUtils.getDayDiff(new Date(), arrived) + 0.1f;
        }
        else {
            return -1;
        }
        return  (2f + dayDiff) / dayDiff * Math.pow(1.2, (float)level) * (distance / 200.0) * seats;
    }

    private int getSecondaryRegionId(String regionString){
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

}
