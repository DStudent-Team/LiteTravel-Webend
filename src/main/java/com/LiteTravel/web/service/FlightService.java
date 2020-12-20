package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.Flight.FlightDTO;
import com.LiteTravel.web.DTO.Flight.FlightReserveDTO;
import com.LiteTravel.web.DTO.Flight.FlightSearchDTO;
import com.LiteTravel.web.DTO.Flight.FlightTicketDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.*;
import com.LiteTravel.web.service.Utils.JDBCUtils;
import com.LiteTravel.web.utils.CustomUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.spi.ResolveResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    FlightMapper flightMapper;
    @Autowired
    FlightReserveMapper flightReserveMapper;
    @Autowired
    FlightTicketMapper flightTicketMapper;
    @Autowired
    FlightCompanyMapper flightCompanyMapper;
    @Autowired
    RegionMapper regionMapper;

    /*  提交 用户对机票的服务需要 */
    public Integer submitFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flightDTO.setFlightFrom(JDBCUtils.getSecondaryRegionId(regionMapper, flightDTO.getFlightFromString()));
        flightDTO.setFlightTo(JDBCUtils.getSecondaryRegionId(regionMapper, flightDTO.getFlightToString()));
        BeanUtils.copyProperties(flightDTO, flight);
        flight.setFlightStatus(0);
        flightMapper.insert(flight);
        return flight.getFlightId();
    }
    /* 提交 服务商对特定预约提供的服务 */
    public void submitReserve(FlightReserveDTO reserveDTO) {
        FlightReserve reserve = new FlightReserve();
        BeanUtils.copyProperties(reserveDTO, reserve);
        reserve.setSelected(false);
        flightReserveMapper.insertSelective(reserve);
        UpdateFlightStatus(reserve.getFlightId(), 1);
    }
    /* 选中某一项服务商提供的服务 */
    public void confirmReserve(FlightReserveDTO reserveDTO) {
        /* 更新服务 */
        FlightReserve reserve = new FlightReserve();
        reserve.setReserveId(reserveDTO.getReserveId());
        reserve.setSelected(true);
        flightReserveMapper.updateByPrimaryKeySelective(reserve);
        /* 更新机票 */
        UpdateFlightStatus(reserveDTO.getFlightId(), 2);
    }

    public void withdrawReserve(FlightReserveDTO reserveDTO) {
        /* 如果状态为已支付, 则需要退回账款 */
        
        /* 更新机票状态 */
        UpdateFlightStatus(reserveDTO.getFlightId(), 1);
    }
    public void payFlight(FlightReserveDTO reserveDTO) {
        /* 将支付金额转入服务商账户 */

        /* 更新机票状态 */
        UpdateFlightStatus(reserveDTO.getFlightId(), 3);
    }
    /* 修改flight的状态 */
    private void UpdateFlightStatus(Integer flightId, Integer status){
        Flight flight = new Flight();
        flight.setFlightId(flightId);
        flight.setFlightStatus(status);
        flightMapper.updateByPrimaryKeySelective(flight);
    }



    /***
     *
     * @param page
     * @param pageSize
     * @param companyId 确认前端数据需要 服务商获取服务被选中信息.
     * @return
     */
    public ResultVO getFlights(Integer page, Integer pageSize, Integer companyId) {
        PageHelper.startPage(page, pageSize);
        List<Flight> flights = flightMapper.selectByExample(new FlightExample());
        PageInfo<Flight> info = new PageInfo<>(flights, 5);
        List<FlightDTO> data = flights.stream().map(flight -> {
            FlightDTO flightDTO = getFlightDTO(flight, false);
            if (companyId != 0){
                if (flightDTO.getFlightStatus() >= 2){
                    Integer flightId = flightDTO.getFlightId();
                    FlightReserveExample flightReserveExample = new FlightReserveExample();
                    flightReserveExample.createCriteria()
                            .andFlightIdEqualTo(flightId)
                            .andCompanyIdEqualTo(companyId)
                            .andSelectedEqualTo(true);
                    List<FlightReserve> flightReserves = flightReserveMapper.selectByExample(flightReserveExample);
                    flightDTO.setIsSelected(flightReserves.size() > 0);
                }
            }
            return flightDTO;
        }).collect(Collectors.toList());
        return new ResultVO(data, info);
    }

    public FlightDTO getFlightById(Integer flightId) {
        Flight flight = flightMapper.selectByPrimaryKey(flightId);
        return getFlightDTO(flight, true);
    }

    private FlightDTO getFlightDTO(Flight flight, boolean ticketFlag) {
        FlightDTO flightDTO = new FlightDTO();
        BeanUtils.copyProperties(flight, flightDTO);
        //地址名
        Region regionFrom = regionMapper.selectByPrimaryKey(flight.getFlightFrom());
        flightDTO.setFlightFromString(regionFrom.getName());
        Region regionTo = regionMapper.selectByPrimaryKey(flight.getFlightTo());
        flightDTO.setFlightToString(regionTo.getName());
        //服务商提供的航班服务信息
        if (flight.getFlightStatus() >= 1 && ticketFlag) {
            FlightReserveExample flightReserveExample = new FlightReserveExample();
            flightReserveExample.createCriteria()
                    .andFlightIdEqualTo(flightDTO.getFlightId());
            List<FlightReserve> flightReserves = flightReserveMapper.selectByExample(flightReserveExample);
            /*设置Reserve*/
            flightDTO.setFlightReserves(flightReserves.stream().map(this::getReserveDTO).collect(Collectors.toList()));
        }
        return flightDTO;
    }


    public ResultVO getReserves(Integer page, Integer pageSize, FlightReserveDTO flightReserveDTO) {
        PageHelper.startPage(page, pageSize);
        List<FlightReserve> reserves = flightReserveMapper.selectByExample(getReserveExample(flightReserveDTO));
        PageInfo<FlightReserve> info = new PageInfo<>(reserves, 5);
        List<FlightReserveDTO> data = reserves.stream().map(this::getReserveDTO).collect(Collectors.toList());
        return new ResultVO(data, info);
    }

    private FlightReserveExample getReserveExample(FlightReserveDTO flightReserveDTO) {
        /* 搜索功能待更新 */
        FlightReserveExample flightReserveExample = new FlightReserveExample();
        FlightReserveExample.Criteria criteria = flightReserveExample.createCriteria();
        if (flightReserveDTO.getCompanyId() != null){
            criteria.andCompanyIdEqualTo(flightReserveDTO.getCompanyId());
        }
        if (flightReserveDTO.getFlightId() != null){
            criteria.andFlightIdEqualTo(flightReserveDTO.getFlightId());
        }
        return flightReserveExample;
    }

    private FlightReserveDTO getReserveDTO(FlightReserve flightReserve){
        FlightReserveDTO flightReserveDTO = new FlightReserveDTO();
        BeanUtils.copyProperties(flightReserve, flightReserveDTO);
        /*获取companyName*/
        FlightCompany flightCompany = flightCompanyMapper.selectByPrimaryKey(flightReserveDTO.getCompanyId());
        flightReserveDTO.setCompanyName(flightCompany.getCompanyName());
        FlightTicketExample flightTicketExample = new FlightTicketExample();
        flightTicketExample.createCriteria()
                .andReserveIdEqualTo(flightReserve.getReserveId());
        List<FlightTicket> flightTickets = flightTicketMapper.selectByExample(flightTicketExample);
        /*设置tickets*/
        if (flightTickets.size() > 0) {
            flightReserveDTO.setFlightTickets(flightTickets.stream().map(flightTicket -> {
                FlightTicketDTO flightTicketDTO = new FlightTicketDTO();
                BeanUtils.copyProperties(flightTicket, flightTicketDTO);
                return flightTicketDTO;
            }).collect(Collectors.toList()));
        } else {
            flightReserveDTO.setFlightTickets(new ArrayList<>());
        }
        return flightReserveDTO;
    }

}
