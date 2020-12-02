package com.LiteTravel.web.DTO;

import lombok.Data;

import java.util.List;

@Data
public class HotelOrderDetailDTO {
    private Integer roomId;
    private Integer hotelId;
    /*roomName 和 roomWifi 是两个需要单独获取的数据*/
    private String roomName;
    private String roomWifi;
    private Float roomPrice;
    private Integer roomCount;
    /*beds 需要单独获取*/
    private List<BedDTO> beds;
}
