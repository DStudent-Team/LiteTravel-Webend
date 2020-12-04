package com.LiteTravel.web.DTO;

import lombok.Data;

import java.util.List;
/*todo 合并进RoomDTO中去*/
@Data
public class HotelOrderDetailDTO {
    private Integer roomId;
    private Integer hotelId;
    private String roomName;
    private Float roomPrice;
    private Integer roomRemaining;
    private String roomWifi;
    private Integer roomCount;
    private List<BedDTO> beds;
}
