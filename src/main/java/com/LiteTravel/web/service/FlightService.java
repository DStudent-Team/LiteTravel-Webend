package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.Flight.FlightDTO;
import com.LiteTravel.web.DTO.Flight.FlightReserveDTO;
import com.LiteTravel.web.DTO.Flight.FlightSearchDTO;
import com.LiteTravel.web.DTO.Flight.FlightTicketDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.*;
import com.LiteTravel.web.service.Utils.JDBCUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Resource
    FlightMapper flightMapper;
    @Resource
    FlightReserveMapper flightReserveMapper;
    @Resource
    FlightTicketMapper flightTicketMapper;
    @Resource
    CompanyMapper companyMapper;
    @Resource
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
    @Transactional
    public void submitReserve(FlightReserveDTO reserveDTO) {
        float total = 0;
        FlightReserve reserve = new FlightReserve();
        BeanUtils.copyProperties(reserveDTO, reserve);
        reserve.setSelected(false);
        flightReserveMapper.insertSelective(reserve);
        Integer reserveId = reserve.getReserveId();
        /* 插入服务 */
        for (FlightTicketDTO flightTicketDTO: reserveDTO.getFlightTickets()){
            FlightTicket flightTicket = new FlightTicket();
            BeanUtils.copyProperties(flightTicketDTO, flightTicket);
            flightTicket.setReserveId(reserveId);
            total = total+flightTicket.getTicketPrice();
            flightTicketMapper.insert(flightTicket);
        }
        /*计算总价*/
        reserve.setTotal(total);
        flightReserveMapper.updateByPrimaryKeySelective(reserve);
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
        FlightReserve reserve = new FlightReserve();
        reserve.setReserveId(reserveDTO.getReserveId());
        reserve.setSelected(false);
        flightReserveMapper.updateByPrimaryKeySelective(reserve);
        UpdateFlightStatus(reserveDTO.getFlightId(), 1);
    }
    public void payFlight(FlightReserveDTO reserveDTO) {

        /* 更新机票状态 */
        UpdateFlightStatus(reserveDTO.getFlightId(), 3);
    }

    /**
     * 修改状态为已支付
     * @param flightId flightId
     * @param status status
     */
    public void UpdateFlightStatus(Integer flightId, Integer status){
        Flight flight = new Flight();
        flight.setFlightId(flightId);
        flight.setFlightStatus(status);
        flightMapper.updateByPrimaryKeySelective(flight);
    }

    public void updateFlight(FlightDTO flightDTO){
        Flight flight = new Flight();
        BeanUtils.copyProperties(flightDTO,flight);
        flightMapper.updateByPrimaryKeySelective(flight);
    }

    /**
     * 获取当前商家可以提供服务的行程
     * @param page pageNum
     * @param pageSize pageSize
     * @param companyId companyId
     * @return ResultVo
     */
    public ResultVO getFlights(Integer page, Integer pageSize, Integer companyId) {
        // 查找非status=2的行程
        FlightExample flightExample = new FlightExample();
        flightExample.createCriteria().andFlightStatusLessThan(2);
        PageHelper.startPage(page, pageSize);
        List<Flight> flights = flightMapper.selectByExample(flightExample);
        PageInfo<Flight> info = new PageInfo<>(flights, 5);
        // 通过companyId查看所有的服务
        FlightReserveExample flightReserveExample = new FlightReserveExample();
        flightReserveExample.createCriteria().andCompanyIdEqualTo(companyId);
        List<FlightReserve> flightReserves = flightReserveMapper.selectByExample(flightReserveExample);
        // 整合DTO
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (FlightReserve flightReserve : flightReserves){
            arrayList.add(flightReserve.getFlightId());
        }
        // 查看所有的行程
        List<FlightDTO> flightDTOS = new ArrayList<>();
        for (Flight flight : flights){
            if (!arrayList.contains(flight.getFlightId())){
                FlightDTO flightDTO = new FlightDTO();
                BeanUtils.copyProperties(flight, flightDTO);
                //设置
                Region fromRegion = regionMapper.selectByPrimaryKey(flight.getFlightFrom());
                flightDTO.setFlightFromString(fromRegion.getName());
                Region toRegion = regionMapper.selectByPrimaryKey(flight.getFlightTo());
                flightDTO.setFlightToString(toRegion.getName());
                flightDTOS.add(flightDTO);
            }
        }
        return new ResultVO(flightDTOS, info);
    }
    /**
     * 获取当前商家可以提供服务的行程
     * @param page pageNum
     * @param pageSize pageSize
     * @param companyId companyId
     * @return ResultVo
     */
    public ResultVO getReserveFlights(Integer page, Integer pageSize, Integer companyId) {
        PageHelper.startPage(page, pageSize);
        List<Flight> flights = flightMapper.selectByExample(new FlightExample());
        PageInfo<Flight> info = new PageInfo<>(flights, 1);
        // 通过companyId查看所有的服务
        FlightReserveExample flightReserveExample = new FlightReserveExample();
        flightReserveExample.createCriteria().andCompanyIdEqualTo(companyId);
        List<FlightReserve> flightReserves = flightReserveMapper.selectByExample(flightReserveExample);
        // 整合DTO
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (FlightReserve flightReserve : flightReserves){
            arrayList.add(flightReserve.getFlightId());
        }
        // 查看所有的行程
        List<FlightDTO> flightDTOS = new ArrayList<>();
        for (Flight flight : flights){
            if (arrayList.contains(flight.getFlightId())){
                FlightDTO flightDTO = new FlightDTO();
                BeanUtils.copyProperties(flight, flightDTO);
                //设置
                Region fromRegion = regionMapper.selectByPrimaryKey(flight.getFlightFrom());
                flightDTO.setFlightFromString(fromRegion.getName());
                Region toRegion = regionMapper.selectByPrimaryKey(flight.getFlightTo());
                flightDTO.setFlightToString(toRegion.getName());
                flightDTOS.add(flightDTO);
            }
        }
        return new ResultVO(flightDTOS, info);
    }

    /***
     *
     * @param page
     * @param pageSize
     * @param companyId 确认前端数据需要 服务商获取服务被选中信息.
     * @return
     */
    public ResultVO getFlights(Integer page, Integer pageSize, Integer companyId, Integer userId) {
        // 只查询当前用户的飞机行程
        FlightExample flightExample = new FlightExample();
        flightExample.createCriteria().andUserIdEqualTo(userId);
        PageHelper.startPage(page, pageSize);
        List<Flight> flights = flightMapper.selectByExample(flightExample);

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
        Company flightCompany = companyMapper.selectByPrimaryKey(flightReserveDTO.getCompanyId());
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

    /* 复合查询 */
    public ResultVO getFlights(Integer page, Integer pageSize, FlightSearchDTO flightSearchDTO) {

        String from = flightSearchDTO.getFlightFromString();
        String to = flightSearchDTO.getFlightToString();
        Date startTime = flightSearchDTO.getStartDate();
        Date endTime = flightSearchDTO.getEndDate();
        String status = flightSearchDTO.getFlightStatus();

        PageHelper.startPage(page, pageSize);
        FlightExample flightExample = new FlightExample();
        RegionExample regionExample = new RegionExample();
        FlightExample.Criteria flightExampleCriteria = flightExample.createCriteria();

        /*这个通过数字代码范围来查询我也不确定行不行, 总之试试看*/
        if (from != null && from.length() > 0) {

            //格式化地址选择器传来的地址信息，只取城市
            from = from.split("/")[1];
            regionExample.createCriteria().andNameLike("%" + from + "%");

            //获取4位地址id，通过范围选择包括下面的区县
            int regionId = regionMapper.selectByExample(regionExample).get(0).getId() / 100;
            flightExampleCriteria.andFlightFromBetween(regionId * 100, regionId * 100 + 99);
        }
        /*这个通过数字代码范围来查询我也不确定行不行, 总之试试看*/
        if (to != null && to.length() > 0) {
            //格式化地址选择器传来的地址信息，只取城市
            to = to.split("/")[1];
            regionExample.createCriteria().andNameLike("%" + to + "%");

            //获取4位地址id，通过范围选择包括下面的区县
            int regionId = regionMapper.selectByExample(regionExample).get(0).getId() / 100;
            flightExampleCriteria.andFlightToBetween(regionId * 100, regionId * 100 + 99);
        }
        if (startTime != null) {
            startTime = new Timestamp(startTime.getTime());
            flightExampleCriteria.andFlightDepartGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null) {
            endTime = new Timestamp(endTime.getTime() + (60 * 60 * 24) * 1000);
            flightExampleCriteria.andFlightDepartLessThanOrEqualTo(endTime);
        }
        if (status != null && status.length() > 0) {
            List<String> statusList = Arrays.asList(status.split(","));
            /* 需将状态列表转成integer类型 */
            List<Integer> toInteger = new ArrayList<>();
            for(String string: statusList) {
                toInteger.add(Integer.parseInt(string));
            }
            flightExampleCriteria.andFlightStatusIn(toInteger);
        }
        List<Flight> flights = flightMapper.selectByExample(flightExample);
        PageInfo<Flight> info = new PageInfo<>(flights, 5);
        List<FlightDTO> data = flights.stream().map(flight -> {
            FlightDTO flightDTO = getFlightDTO(flight, false);
            return flightDTO;
        }).collect(Collectors.toList());
        return new ResultVO(data, info);
    }
    /* 删除机票行程信息 */
    public int deleteFlight(Integer flightId) {
        FlightReserveExample flightReserveExample = new FlightReserveExample();
        flightReserveExample.createCriteria().andFlightIdEqualTo(flightId);
        List<FlightReserve> flightReserves= flightReserveMapper.selectByExample(flightReserveExample);
        List<Integer> reserveIds = flightReserves.stream().map(FlightReserve::getReserveId).collect(Collectors.toList());
        if (reserveIds.size() > 0){
            FlightTicketExample ticketExample = new FlightTicketExample();
            ticketExample.createCriteria().andReserveIdIn(reserveIds);
            flightTicketMapper.deleteByExample(ticketExample);
            flightReserveMapper.deleteByExample(flightReserveExample);
        }
        return flightMapper.deleteByPrimaryKey(flightId);
    }
    /* 删除机票服务信息 */
    public int deleteReserve(Integer reserveId) {
        FlightTicketExample flightTicketExample = new FlightTicketExample();
        flightTicketExample.createCriteria().andReserveIdEqualTo(reserveId);
        flightTicketMapper.deleteByExample(flightTicketExample);
        return flightReserveMapper.deleteByPrimaryKey(reserveId);
    }

    /* 更新机票服务*/
    public int updateReserve(Integer reserveId, String service) {
        FlightReserve flightReserve = new FlightReserve();
        flightReserve.setReserveId(reserveId);
        flightReserve.setService(service);
        return flightReserveMapper.updateByPrimaryKeySelective(flightReserve);
    }
}
