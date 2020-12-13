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
    String status;
    //酒店地址，格式 中国,xx省,xx市
    /*实际使用时, 肯定不是传输全名, 而是传输一个数字代码, 因此也非常简单*/
//    Integer address;
    Integer address;
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
