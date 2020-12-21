package com.LiteTravel.web.DTO.Flight;

import lombok.Data;

import java.util.Date;

@Data
public class FlightSearchDTO {
    String flightFromString;//出发地全名
    String flightToString;//目的地全名
    Date startDate;//出发起始时间
    Date endDate;//出发终止时间
    String flightStatus;//预定状态, 1为未付费, 2为未预约, 3为预约成功尚未出发, 4为行程结束
}
