package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Line;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LineMapper {
    public List<Line> getAllLines();
}
