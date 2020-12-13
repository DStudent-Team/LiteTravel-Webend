package com.LiteTravel.web.DTO.Region;

import lombok.Data;

@Data
public class RegionDTO {
    Integer id;
    String name;//地区名
    Integer pid;
    String mername;// 全名
    Integer level;
    Boolean isCity;
}
