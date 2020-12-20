package com.LiteTravel.web.DTO.Flight;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FlightDTO {
    Integer flightId;
    Integer userId;
    Integer flightLevel;//机舱级别
    Integer flightFrom;//出发地RegionId
    String flightFromString;//出发地全名
    Integer flightTo;//目的地RegionId
    String flightToString;//目的地全名
    Date flightDepart;//预计出发时间或准确起飞时间
    Date flightArrived;//预计到达时间或准确到达时间
    Float flightTotal;//预计价格和实际价格
    Integer flightSeats;//乘坐人数
    Integer flightStatus;//预定状态, 0为未有服务商提供服务, 1为未选择服务, 2为未支付, 3为支付成功尚未出发, 4为行程结束
    List<FlightReserveDTO> flightReserves;
    Boolean isSelected; // (登陆服务商的服务)是否被(用户)选中
}
