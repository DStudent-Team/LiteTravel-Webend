package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Line;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LineMapper {
    public List<Line> getAllLines();
}
