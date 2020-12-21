package com.LiteTravel.web.DTO.HotelOrder;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HotelOrderQueryDTO {
    Integer userId;
    //酒店名关键字
    String keyword;
    /*用于查询订单的发出时间*/
    Date startDate;
    Date endDate;
    //订单状态
    String status = "";
    //酒店地址，格式 xx省,xx市
    String address;
    /*以,分割的一串酒店id字符串*/
    String hotelIds;
    /*后续还可以添加排序功能*/

    @Override
    public String toString() {
        return "HotelOrderQueryDTO{" +
                "userId=" + userId +
                ", keyword='" + keyword + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", address=" + address +
                '}';
    }
}
