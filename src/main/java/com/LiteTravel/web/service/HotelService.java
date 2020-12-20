package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.DTO.HotelOrder.HotelOrderDetailDTO;
import com.LiteTravel.web.DTO.HotelQueryDTO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
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
        return new ResultVO((List<HotelDTO>) new ArrayList(), info);
    }

    // 展现酒店单页
//    @Cacheable(cacheNames = {"hotel"}, key = "#hotelId + '[' + #roomFlag + ']'")
    public HotelDTO selectHotelById(Integer hotelId, boolean roomFlag){
        Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);
        HotelDTO hotelDTO = new HotelDTO();
        // 获得基本数据
        BeanUtils.copyProperties(hotel, hotelDTO);
        // 写入地址信息
        RegionExample regionExample = new RegionExample();
        regionExample.createCriteria()
                .andIdEqualTo(hotel.getHotelAddress());
        List<Region> regions = regionMapper.selectByExample(regionExample);
        if(regions.size() > 0){
            hotelDTO.setHotelAddressString(regions.get(0).getMername());
        }
        // 判断是否需要room数据, 借此获得Room数据
        if(roomFlag){
            RoomExample roomExample = new RoomExample();
            roomExample.createCriteria()
                    .andHotelIdEqualTo(hotelId);
            List<Room> rooms = roomMapper.selectByExample(roomExample);
            List<RoomDTO> roomDTOs = rooms.stream().map(this::getRoomDTO).collect(Collectors.toList());
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

    //根據酒店名称查询酒店是否存在，存在则返回0.不存在返回1
    public List<Hotel> checkHotelByName(String hotelName){
        HotelExample hotelExample = new HotelExample();
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
    public void updateHotel() {

//        Hotel hotel = new Hotel();
//        //利用反射属性对JaveBean进行处理，简单说就是将hotelDto转化成hotel类
//        BeanUtils.copyProperties(hotelDTO, hotel);
//        hotelMapper.updateByPrimaryKeySelective(hotel);
//        //逆向工程方法，添加条件，相当于where语句
//        RoomExample roomExample = new RoomExample();
//        roomExample.createCriteria()
//                .andHotelIdEqualTo(hotel.getHotelId());
    }

    //添加数据
    public int insertHotel(HotelDTO hotelDTO){
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setHotelMinPrice(hotelDTO.getHotelMinPrice());
        hotel.setHotelManagerId(hotelDTO.getHotelManagerId());
        hotel.setHotelPhone(hotelDTO.getHotelPhone());
        hotel.setHotelReplyLevel(hotelDTO.getHotelReplyLevel());

        return 1;
    }

    private  HotelExample getHotelExample(HotelQueryDTO query) {

        String keyword = query.getKeyword();
        Integer minPrice = query.getMinPrice();
        Integer maxPrice = query.getMaxPrice();

        HotelExample hotelExample = new HotelExample();
        HotelExample.Criteria hotelExampleCriteria = hotelExample.createCriteria();
        HotelExample.Criteria hotelExampleCriteria1 = hotelExample.createCriteria();

        if (keyword != null) {

            hotelExampleCriteria.andHotelNameLike("%" + keyword + "%");
            hotelExampleCriteria1.andHotelDescriptionLike("%" + keyword + "%");
        }
        if (minPrice != null) {
            hotelExampleCriteria.andHotelMinPriceGreaterThanOrEqualTo(minPrice);
            hotelExampleCriteria1.andHotelMinPriceGreaterThanOrEqualTo(minPrice);
        }
        if (maxPrice != null) {
            hotelExampleCriteria.andHotelMinPriceLessThanOrEqualTo(maxPrice);
            hotelExampleCriteria1.andHotelMinPriceLessThanOrEqualTo(maxPrice);
        }
        hotelExample.or(hotelExampleCriteria);
        hotelExample.or(hotelExampleCriteria1);
        return hotelExample;
    }
}
