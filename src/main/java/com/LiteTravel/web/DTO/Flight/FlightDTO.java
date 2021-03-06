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
    Integer flightStatus;//预定状态, 1为未付费, 2为未预约, 3为预约成功尚未出发, 4为行程结束
    List<FlightReserveDTO> flightReserves;//所有预定到的机票数据
    Boolean isSelected;//【(登陆服务商的服务)是否被(用户)选中】只在后台机票服务提供商界面使用, 目的是获取 用户选择服务后, 是否选择的是 登录服务商 的 服务
}
