package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Agency;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AgencyMapper {
    public Agency getAgencyById(Integer id);
}
