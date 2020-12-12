package com.LiteTravel.web.DTO;


import lombok.Data;

import java.util.List;

@Data
public class HotelOrderQueryCriteriaDTO {

    //酒店名关键字
    String hotelName;
    //起始时间，格式 yyyy-mm-dd
    String startTime;
    //终止时间，格式 yyyy-mm-dd
    String endTime;
    //订单状态
    List<String> status;
    //酒店地址，格式 中国,xx省,xx市
    String hotelAddress;
}
