package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.DTO.HotelOrder.HotelOrderDetailDTO;
import com.LiteTravel.web.DTO.HotelQueryDTO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.*;
import com.LiteTravel.web.service.Utils.JDBCUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.catalina.Manager;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.scene.effect.DisplacementMapBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class
HotelService {

    @Autowired
    public HotelMapper hotelMapper;

    @Autowired
    public RoomMapper roomMapper;

    @Autowired
    public RoomBedMapMapper roomBedMapper;

    @Autowired
    public BedMapper bedMapper;

    @Autowired
    public RegionMapper regionMapper;

    @Resource
    private HotelManagerMapper hotelManagerMapper;


    @Autowired
    public HotelOrderMapper hotelOrderMapper;

    @Autowired
    public HotelOrderDetailMapper hotelOrderDetailMapper;
    // 默认酒店列表
//    @Cacheable(cacheNames = {"hotels"}, key = "#page")
    public ResultVO getHotels(Integer page, Integer pageSize){
        return selectByExample(page, pageSize, new HotelExample());
    }

    public ResultVO getHotels(Integer page, Integer pageSize, HotelQueryDTO hotelQueryDTO){
        return selectByExample(page, pageSize, getHotelExample(hotelQueryDTO));
    }

    // 推荐酒店
//    @Cacheable(cacheNames = {"relateHotels"}, key = "#hotelId")
    public ResultVO getHotels(Integer hotelId, Integer page, Integer pageSize)
    {
        HotelExample hotelExample = new HotelExample();
//      todo 推荐算法尚未写好
        hotelExample.createCriteria()
                .andHotelIdNotEqualTo(hotelId);
        return selectByExample(page, pageSize, hotelExample);
}

    private ResultVO selectByExample(Integer page, Integer pageSize, HotelExample hotelExample){
        /* 分页：
         * 参数1: 第几页
         * 参数2: 每页展示几个数据 */
        PageHelper.startPage(page, pageSize);
        List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);
        PageInfo<Hotel> info = new PageInfo<>(hotels, 5);
        if (hotels.size() > 0) {
            List<Integer> addressIds = hotels.stream().map(Hotel::getHotelAddress).distinct().collect(Collectors.toList());
            RegionExample regionExample = new RegionExample();
            regionExample.createCriteria()
                    .andIdIn(addressIds);
            List<Region> regions = regionMapper.selectByExample(regionExample);
            Map<Integer, String> addressMap = regions.stream().collect(Collectors.toMap(Region::getId, Region::getMername));
            List<HotelDTO> data = hotels.stream().map(hotel -> {
                HotelDTO hotelDTO = new HotelDTO();
                BeanUtils.copyProperties(hotel, hotelDTO);
                // 写入地址数据 hotelTotalAddress;
                String addressString = addressMap.get(hotel.getHotelAddress());
                hotelDTO.setHotelAddressString(addressString.substring(addressString.indexOf("省,") + 2));
                return hotelDTO;
            }).collect(Collectors.toList());
            return new ResultVO(data, info);
        }
        return new ResultVO( new ArrayList<HotelDTO>(), info);
    }

    // 展现酒店单页
//    @Cacheable(cacheNames = {"hotel"}, key = "#hotelId + '[' + #roomFlag + ']'")
    public HotelDTO selectHotelById(Integer hotelId, boolean roomFlag, Date startTime, Date endTime){
        Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);
        HotelDTO hotelDTO = JDBCUtils.initHotelDTO(regionMapper, hotel);
        // 判断是否需要room数据, 借此获得Room数据
        if(roomFlag){
            RoomExample roomExample = new RoomExample();
            roomExample.createCriteria()
                    .andHotelIdEqualTo(hotelId);
            List<Room> rooms = roomMapper.selectByExample(roomExample);
            List<RoomDTO> roomDTOs = rooms.stream().map(this::getRoomDTO).collect(Collectors.toList());

            //根据时间设定剩余房间数
            List<Integer> roomType = this.getRoomType(hotelId);
            List<Integer> remainRooms = this.getRemainRooms(startTime, endTime, hotelId, roomType);
            for (int index = 0; index < roomDTOs.size(); index++) {
                roomDTOs.get(index).setRoomRemaining(remainRooms.get(index));
            }
            hotelDTO.setRooms(roomDTOs);
        }
        return hotelDTO;
    }

    public RoomDTO getRoomDTO(Integer roomId){
        return getRoomDTO(roomMapper.selectByPrimaryKey(roomId));
    }

    public List<HotelOrderDetailDTO> getHotelOrderDetailByRoomIds(List<Integer> roomIds) {
        List<RoomDTO> roomDTOs = getRoomDTObyIds(roomIds);
        return roomDTOs.stream().map(roomDTO -> {
            HotelOrderDetailDTO hotelOrderDetailDTO = new HotelOrderDetailDTO();
            BeanUtils.copyProperties(roomDTO, hotelOrderDetailDTO);
            return hotelOrderDetailDTO;
        }).collect(Collectors.toList());
    }

    public List<RoomDTO> getRoomDTObyIds(List<Integer> roomIds) {
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria()
                .andRoomIdIn(roomIds);
        return getRoomDTOs(roomMapper.selectByExample(roomExample));
    }
    private RoomDTO getRoomDTO(Room room){
        RoomDTO roomDTO = new RoomDTO();
        BeanUtils.copyProperties(room, roomDTO);

        // 获取roomBedMap
        RoomBedMapExample roomBedMapExample = new RoomBedMapExample();
        roomBedMapExample.createCriteria()
                .andRoomIdEqualTo(room.getRoomId());
        List<RoomBedMap> roomBedMaps = roomBedMapper.selectByExample(roomBedMapExample);
        List<Integer> bedIds = roomBedMaps.stream().map(RoomBedMapKey::getBedId).distinct().collect(Collectors.toList());
        // 获取bed
        BedExample bedExample = new BedExample();
        bedExample.createCriteria()
                .andBedIdIn(bedIds);
        List<Bed> bedList = bedMapper.selectByExample(bedExample);
        // 获取bedCount
        Map<Integer, Integer> bedCountMap = roomBedMaps.stream().collect(Collectors.toMap(RoomBedMapKey::getBedId, RoomBedMap::getBedCount));
        // bed和bedCount写入bedDTO
        List<BedDTO> bedDTOs = bedList.stream().map(bed -> {
            BedDTO bedDTO = new BedDTO();
            BeanUtils.copyProperties(bed, bedDTO);
            bedDTO.setBedCount(bedCountMap.get(bed.getBedId()));
            return bedDTO;
        }).collect(Collectors.toList());
        roomDTO.setBeds(bedDTOs);
        return roomDTO;
    }
    private List<RoomDTO> getRoomDTOs(List<Room> rooms){
        return rooms.stream().map(this::getRoomDTO).collect(Collectors.toList());
    }

    //增刪改方法
    public int checkHotelId(HotelDTO hotelDTO){
        //查询hotelHTO是否包含hotelId值，如果包含表示是更新方法，否则是插入方法返回0
        if(hotelDTO.getHotelId() == null){
            return 0;
        }
        return 1;
    }

    //根據酒店名称查询酒店是否存在，存在则返回0.不存在返回1
    public List<Hotel> checkHotelByName(HotelDTO hotelDTO){
        String hotelName = hotelDTO.getHotelName();
        HotelExample hotelExample = new HotelExample();
        // 逆向工程方法，查询条件，相当于where语句
        hotelExample.createCriteria()
                .andHotelNameEqualTo(hotelName);
        return hotelMapper.selectByExample(hotelExample);
    }

    //删除，接收传递过来的id值进行数据库修改
    public int deleteHotel(Integer hotelId){
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andHotelIdEqualTo(hotelId);
        List<Room> rooms = new ArrayList<>();
        //rooms是需要的对象
        rooms = roomMapper.selectByExample(roomExample);
        //取出来hotel中的对应的room_id值，进行接下来的删除操作
        List<Integer> roomIds = rooms.stream().map(Room::getRoomId).distinct().collect(Collectors.toList());
        //遍历room_id，逐个删除room_id对应的bed和room
        for(int i=0;i<roomIds.size();i++){//list为集合的对象名
            Integer roomId =  roomIds.get(i);
            RoomBedMapExample roomBedMapExample = new RoomBedMapExample();
            roomBedMapExample.createCriteria()
                    .andRoomIdEqualTo(roomId);
            roomBedMapper.deleteByExample(roomBedMapExample);
            roomMapper.deleteByPrimaryKey(roomId);
        }
        int result = hotelMapper.deleteByPrimaryKey(hotelId);
        return result;
    }

    //修改酒店數據
    public int updateHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        //利用反射属性对JaveBean进行处理，简单说就是将hotelDto转化成hotel类
        BeanUtils.copyProperties(hotelDTO, hotel);
        HotelExample hotelExample = new HotelExample();
        hotelExample.createCriteria()
                .andHotelIdEqualTo(hotel.getHotelId());
        //酒店图片设置默认值，count初始值设置为0
        hotel.setHotelImgUri("hotel-1.jpg");
        hotel.setHotelReplyCount(0);
        int result = 0;
            result = hotelMapper.updateByExample(hotel, hotelExample);
        return result;
    }

    //添加数据
    public int insertHotel(HotelDTO hotelDTO){
        Hotel hotel = new Hotel();
        //利用反射属性对JaveBean进行处理，简单说就是将hotelDto转化成hotel类
        BeanUtils.copyProperties(hotelDTO, hotel);
        //设置默认值
        hotel.setHotelImgUri("hotel-1.jpg");
        hotel.setHotelReplyCount(0);
        int insert = 0;
            insert = hotelMapper.insert(hotel);
        System.out.println(insert);
        return insert;
    }

    private  HotelExample getHotelExample(HotelQueryDTO query) {

        String keyword = query.getKeyword();
        Integer minPrice = query.getMinPrice();
        Integer maxPrice = query.getMaxPrice();
        String address = query.getAddress();

        HotelExample hotelExample = new HotelExample();
        RegionExample regionExample = new RegionExample();

        //写两个是因为要做关键字的并列查询（酒店名和简介）,keyword存在时将两个条件并列返回，否则只返回一个条件
        HotelExample.Criteria hotelExampleCriteria = hotelExample.createCriteria();
        HotelExample.Criteria hotelExampleCriteria1 = hotelExample.createCriteria();

        if (address != null && address.length() > 0) {

            //格式化地址选择器传来的地址信息，只取城市
            address = address.split("/")[1];
            regionExample.createCriteria().andNameLike("%" + address + "%");

            //获取4位地址id，通过范围选择包括下面的区县
            int regionId = regionMapper.selectByExample(regionExample).get(0).getId() / 100;
            hotelExampleCriteria.andHotelAddressBetween(regionId * 100, regionId * 100 + 99);
            hotelExampleCriteria1.andHotelAddressBetween(regionId * 100, regionId * 100 + 99);
        }
        if (minPrice != null) {
            hotelExampleCriteria.andHotelMinPriceGreaterThanOrEqualTo(minPrice);
            hotelExampleCriteria1.andHotelMinPriceGreaterThanOrEqualTo(minPrice);
        }
        if (maxPrice != null) {
            hotelExampleCriteria.andHotelMinPriceLessThanOrEqualTo(maxPrice);
            hotelExampleCriteria1.andHotelMinPriceLessThanOrEqualTo(maxPrice);
        }
        if (keyword != null) {
            hotelExampleCriteria.andHotelNameLike("%" + keyword + "%");
            hotelExampleCriteria1.andHotelDescriptionLike("%" + keyword + "%");
            hotelExample.or(hotelExampleCriteria1);
        }
        return hotelExample;
    }

    /**
     * 获取酒店的所有房间类型
     * @param hotelId 酒店id
     * @return roomType 房间类型列表
     */
    public List<Integer> getRoomType(Integer hotelId) {

        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andHotelIdEqualTo(hotelId);
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        List<Integer> roomType = rooms.stream().map(Room::getRoomId).distinct().collect(Collectors.toList());
        return roomType;
    }

    /**
     * 查询酒店某个房间类型的剩余数量
     * @param startTime 起始时间
     * @param endTime 终止时间
     * @param hotelId 酒店id
     * @param roomId 房间类型Id
     * @return remain 对应时间段内，该酒店该房间类型的剩余数目
     */
    public Integer getRemainRoom(Date startTime, Date endTime, Integer hotelId, Integer roomId) {

        //返回值
        Integer remainRoom = roomMapper.selectByPrimaryKey(roomId).getRoomMax();

        /* 获取相关房间类型的订单id */
        HotelOrderDetailExample hotelOrderDetailExample = new HotelOrderDetailExample();
        hotelOrderDetailExample.createCriteria()
                .andRoomIdEqualTo(roomId);
        List<HotelOrderDetail> hotelOrderDetails = hotelOrderDetailMapper.selectByExample(hotelOrderDetailExample);
        List<Integer> orderIds = hotelOrderDetails.stream().map(HotelOrderDetail::getOrderId).distinct().collect(Collectors.toList());

        /* 通过时间条件查找有效订单，即在对应时间段占用了房间的订单 */
        HotelOrderExample hotelOrderExample = new HotelOrderExample();
        if (orderIds.size() > 0) {
            hotelOrderExample.or()
                    .andOrderIdIn(orderIds)
                    .andCheckInLessThanOrEqualTo(startTime)
                    .andCheckOutGreaterThanOrEqualTo(startTime);
            hotelOrderExample.or()
                    .andOrderIdIn(orderIds)
                    .andCheckInBetween(startTime, endTime);
            List<HotelOrder> hotelOrders = hotelOrderMapper.selectByExample(hotelOrderExample);
            for (HotelOrder order: hotelOrders) {
                remainRoom -= hotelOrderDetailMapper.selectByPrimaryKey(order.getOrderId()).getRoomCount();
            }
        }
        return remainRoom;
    }

    public List<Integer> getRemainRooms(Date startTime, Date endTime, Integer hotelId, List<Integer> roomId) {
        List<Integer> remainRooms = new ArrayList<>();
        for (Integer id : roomId) {
            remainRooms.add(getRemainRoom(startTime, endTime, hotelId, id));
        }
        return remainRooms;
    }
    /**
     * 通过hotelId找到managerId
     * @param hotelId hotelId
     * @return managerId
     */
    public Integer findManagerIdByHotelId(Integer hotelId){

        HotelManagerExample hotelManagerExample = new HotelManagerExample();
        hotelManagerExample.createCriteria().andHotelIdEqualTo(hotelId);
        List<HotelManager> hotelManagers = hotelManagerMapper.selectByExample(hotelManagerExample);
        if (hotelManagers.isEmpty()){
            return -1;
        }
        else{
            return hotelManagers.get(0).getHotelManagerId();
        }
    }

}
