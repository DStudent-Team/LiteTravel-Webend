package com.LiteTravel.web.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomDTO {
    private Integer roomId;
    private Integer hotelId;
    private String roomName;
    private BigDecimal roomPrice;
    private Integer roomRemaining;
    private Integer roomMax;
    private Integer roomBookMax;
    private Integer roomCancel;
    private Integer roomSize;
    private Byte roomWifi;
    private BigDecimal roomBedAdd;
    private String roomDescription;
    private List<BedDTO> beds;

}
