package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.DTO.HotelOrder.*;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.*;
import com.LiteTravel.web.service.Utils.JDBCUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/*要将HotelOrderService整合进HotelService, 高强度耦合*/
@Service
public class HotelOrderService {

    @Resource
    public HotelMapper hotelMapper;
    @Resource
    public RoomMapper roomMapper;
    @Resource
    public RoomBedMapMapper roomBedMapMapper;
    @Resource
    public BedMapper bedMapper;
    @Resource
    public HotelOrderMapper hotelOrderMapper;
    @Resource
    public HotelOrderDetailMapper hotelOrderDetailMapper;
    @Resource
    public RegionMapper regionMapper;

    public ResultVO getOrders(Integer page, Integer pageSize){
        return selectByExample(page, pageSize, new HotelOrderExample());
    }
    public ResultVO getOrders(Integer page, Integer pageSize, Integer userId){
        HotelOrderExample hotelOrderExample = new HotelOrderExample();
        hotelOrderExample.createCriteria().andUserIdEqualTo(userId);
        return selectByExample(page, pageSize, hotelOrderExample);
    }

    public ResultVO getOrders(Integer page, Integer pageSize, HotelOrderQueryDTO hotelOrderQueryDTO) {
        return selectByExample(page, pageSize, getHotelOrderExample(hotelOrderQueryDTO));
    }

    public ResultVO selectByExample(Integer page, Integer pageSize, HotelOrderExample hotelOrderExample) {
        /* 分页：
         * 参数1: 第几页
         * 参数2: 每页展示几个数据 */
        PageHelper.startPage(page, pageSize);

        hotelOrderExample.setOrderByClause("create_date desc");
        List<HotelOrder> hotelOrders = hotelOrderMapper.selectByExample(hotelOrderExample);
        PageInfo<HotelOrder> info = new PageInfo<>(hotelOrders, 5);
        List<Integer> hotelIds = hotelOrders.stream().map(HotelOrder::getHotelId).distinct().collect(Collectors.toList());
        Map<Integer, String> hotelNameMap;
        Map<Integer, String> hotelUriMap;
        if (hotelIds.size() > 0){
            HotelExample hotelExample = new HotelExample();
            hotelExample.createCriteria()
                    .andHotelIdIn(hotelIds);
            List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);
            hotelNameMap = hotels.stream().collect(Collectors.toMap(Hotel::getHotelId, Hotel::getHotelName));
            hotelUriMap = hotels.stream().collect(Collectors.toMap(Hotel::getHotelId, Hotel::getHotelImgUri));
        }else {
            hotelNameMap = new HashMap<>();
            hotelUriMap = new HashMap<>();
        }
        List<HotelOrderBlockDTO> data = hotelOrders.stream().map(hotelOrder -> {
            HotelOrderBlockDTO hotelOrderDTO = new HotelOrderBlockDTO();
            BeanUtils.copyProperties(hotelOrder, hotelOrderDTO);
            String hotelName = hotelNameMap.get(hotelOrder.getHotelId());;
            String hotelUri = hotelUriMap.get(hotelOrder.getHotelId());
            hotelOrderDTO.setHotelName(hotelName);
            hotelOrderDTO.setHotelImgUri(hotelUri);
            return hotelOrderDTO;
        }).collect(Collectors.toList());

        return new ResultVO(data, info);
    }


    public List<HotelOrderBlockDTO> selectAll(){
        return hotelOrderMapper.selectByExample(new HotelOrderExample()).stream().map(hotelOrder ->{
            HotelOrderBlockDTO hotelOrderDTO = new HotelOrderBlockDTO();
            BeanUtils.copyProperties(hotelOrder, hotelOrderDTO);
            return hotelOrderDTO;
        }).collect(Collectors.toList());
    }

    public HotelOrderInfoDTO getHotelOrderInfoById(Integer orderId){
        //最终返回的数据类型
        HotelOrderInfoDTO hotelOrderDTO = new HotelOrderInfoDTO();

        HotelOrder hotelOrder = hotelOrderMapper.selectByPrimaryKey(orderId);
        HotelOrderDetailExample hotelOrderDetailExample = new HotelOrderDetailExample();
        hotelOrderDetailExample.createCriteria()
                .andOrderIdEqualTo(orderId);
        List<HotelOrderDetail> hotelOrderDetails = hotelOrderDetailMapper.selectByExample(hotelOrderDetailExample);

        BeanUtils.copyProperties(hotelOrder, hotelOrderDTO);
        Hotel hotel = hotelMapper.selectByPrimaryKey(hotelOrder.getHotelId());
        HotelDTO hotelDTO = JDBCUtils.initHotelDTO(regionMapper, hotel);
        hotelOrderDTO.setHotel(hotelDTO);
        List<HotelOrderDetailDTO> hotelOrderDetailDTOs = hotelOrderDetails.stream().map(hotelOrderDetail -> {
            HotelOrderDetailDTO hotelOrderDetailDTO = new HotelOrderDetailDTO();
            BeanUtils.copyProperties(hotelOrderDetail, hotelOrderDetailDTO);
            /*获取房间信息和对应床型数据*/
            return hotelOrderDetailDTO;
        }).collect(Collectors.toList());
        hotelOrderDTO.setDetails(hotelOrderDetailDTOs);
        return hotelOrderDTO;
    }
    /*
    * 插入新的订单
    * */
    public int insertHotelOrder(HotelOrder hotelOrder, List<HotelOrderDetail> hotelOrderDetails){
        hotelOrderMapper.insert(hotelOrder);
        int insertId = hotelOrder.getOrderId();
        for (HotelOrderDetail hotelOrderDetail : hotelOrderDetails){
            hotelOrderDetail.setOrderId(insertId);
            hotelOrderDetailMapper.insert(hotelOrderDetail);
        }
        return insertId;
    }

    /**
     * 更新订单状态为已支付
     * @param orderId
     * @return
     */
    public int updateHotelOrder(Integer orderId){
        //支付日期
        Date pay_date = new Date();
        HotelOrder hotelOrder = new HotelOrder();
        hotelOrder.setOrderId(orderId);
        hotelOrder.setPayDate(pay_date);
        hotelOrder.setStatus("1");
        return hotelOrderMapper.updateByPrimaryKeySelective(hotelOrder);
    }

    /**
     * 更新订单状态
     * @param orderId 订单id
     * @param status 订单状态
     * @return int
     */
    public int updateHotelOrderStatus(Integer orderId, String status){
        HotelOrder hotelOrder = new HotelOrder();
        hotelOrder.setOrderId(orderId);
        hotelOrder.setPayDate(new Date());
        hotelOrder.setStatus(status);
        return hotelOrderMapper.updateByPrimaryKeySelective(hotelOrder);
    }

    public int deleteOrder(Integer orderId) {
        HotelOrderDetailExample hotelOrderDetailExample = new HotelOrderDetailExample();
        hotelOrderDetailExample.createCriteria()
                .andOrderIdEqualTo(orderId);
        int i = hotelOrderDetailMapper.deleteByExample(hotelOrderDetailExample);
        return i & hotelOrderMapper.deleteByPrimaryKey(orderId);
    }

    public int confirmOrder(Integer orderId) {
        HotelOrder hotelOrder = hotelOrderMapper.selectByPrimaryKey(orderId);
        String status = hotelOrder.getStatus();
        HotelOrder modified = new HotelOrder();
        modified.setOrderId(orderId);
        switch (status){
            case "1":
                Date checkIn = new Date();
                modified.setConfirmCheckIn(checkIn);
                modified.setStatus("2");
                break;
            case "2":
                Date checkOut = new Date();
                if (hotelOrder.getConfirmCheckIn() == null){
                    modified.setConfirmCheckIn(checkOut);
                }
                modified.setConfirmCheckOut(checkOut);
                modified.setStatus("3");
                break;
            default:
               break;
        }
        return hotelOrderMapper.updateByPrimaryKeySelective(modified);
    }

    private HotelOrderExample getHotelOrderExample(HotelOrderQueryDTO query) {
        //获取查询条件
        Integer userId = query.getUserId();
        String keyword = query.getKeyword();
        Date startTime = query.getStartDate();
        Date endTime = query.getEndDate();
        String status = query.getStatus();
        String address = query.getAddress();
        String hotelId = query.getHotelIds();
        Date checkInDateFrom = query.getCheckInDateFrom();
        Date checkInDateTo = query.getCheckInDateTo();

        //获取权限

        HotelOrderExample hotelOrderExample = new HotelOrderExample();
        HotelExample hotelExample = new HotelExample();
        RegionExample regionExample = new RegionExample();
        HotelExample.Criteria hotelExampleCriteria = hotelExample.createCriteria();

        HotelOrderExample.Criteria hotelOrderExampleCriteria = hotelOrderExample.createCriteria();

        if (keyword != null) {
            hotelExampleCriteria.andHotelNameLike("%" + keyword + "%");
        }
        /*这个通过数字代码范围来查询我也不确定行不行, 总之试试看*/
        if (address != null && address.length() > 0) {

            //格式化地址选择器传来的地址信息，只取城市
            address = address.split("/")[1];
            regionExample.createCriteria().andNameLike("%" + address + "%");

            //获取4位地址id，通过范围选择包括下面的区县
            int regionId = regionMapper.selectByExample(regionExample).get(0).getId() / 100;
            hotelExampleCriteria.andHotelAddressBetween(regionId * 100, regionId * 100 + 99);
        }

        List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);
        List<Integer> hotelIds = hotels.stream().map(Hotel::getHotelId).distinct().collect(Collectors.toList());

        if (userId != null) {
            hotelOrderExampleCriteria.andUserIdEqualTo(userId);
        }
        /* 设置订单创建的时间区间 */
        if (startTime != null){
            startTime = new Timestamp(startTime.getTime());
            hotelOrderExampleCriteria.andCreateDateGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null) {
            endTime = new Timestamp(endTime.getTime() + (60 * 60 * 24) * 1000);
            hotelOrderExampleCriteria.andCreateDateLessThanOrEqualTo(endTime);
        }

        /* 设置入住时间区间 */
        if (checkInDateFrom != null){
            status = "3";
            query.setStatus(status);
            checkInDateFrom = new Timestamp(checkInDateFrom.getTime());
            hotelOrderExampleCriteria.andConfirmCheckInGreaterThanOrEqualTo(checkInDateFrom);
        }
        if (checkInDateTo != null) {
            status = "3";
            query.setStatus(status);
            checkInDateTo = new Timestamp(checkInDateTo.getTime() + (60 * 60 * 24) * 1000);
            hotelOrderExampleCriteria.andConfirmCheckInLessThanOrEqualTo(checkInDateTo);
        }

        /* 设置订单状态 */
        if (status != null && status.length() > 0) {
            List<String> statusList = Arrays.asList(status.split(","));
            hotelOrderExampleCriteria.andStatusIn(statusList);
        }

        if (hotelId != null && hotelId.length() > 0) {
            String[] strings = hotelId.split(",");
            List<Integer> hotelIds1 = new ArrayList<>();
            for(String string: strings) {
                if (! hotelIds.contains(Integer.parseInt(string))) {
                    hotelIds.add(Integer.parseInt(string));
                }
            }
        }

        //防止example生成空hotel报错, 加上这一条并不会影响查询到错误的结果
        hotelIds.add(-1);
        hotelOrderExampleCriteria.andHotelIdIn(hotelIds);
        return hotelOrderExample;

    }
}
