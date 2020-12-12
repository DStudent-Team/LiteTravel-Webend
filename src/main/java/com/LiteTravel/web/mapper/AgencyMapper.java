package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Agency;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyMapper {
    public Agency getAgencyById(Integer id);
}
