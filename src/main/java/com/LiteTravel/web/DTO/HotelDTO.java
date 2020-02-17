package com.LiteTravel.web.DTO;

import lombok.Data;

import java.util.List;

@Data
public class HotelDTO {
    private Integer hotelId;
    private String hotelName;
    private Integer hotelMinPrice;
    private Integer hotelManagerId;
    private String hotelPhone;
    private Integer hotelReplyLevel;
    private String hotelAddress;
    private String hotelAddressSpecific;
    private String hotelImgUri;
    private Integer hotelReplyCount;
    private String hotelDescription;
    private List<RoomDTO> rooms;
}
