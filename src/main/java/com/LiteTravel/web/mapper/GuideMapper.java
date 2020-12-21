package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Guide;
import com.LiteTravel.web.Model.GuideExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideMapper {
    long countByExample(GuideExample example);

    int deleteByExample(GuideExample example);

    int deleteByPrimaryKey(Integer guideId);

    int insert(Guide record);

    int insertSelective(Guide record);

    List<Guide> selectByExample(GuideExample example);

    Guide selectByPrimaryKey(Integer guideId);

    int updateByExampleSelective(@Param("record") Guide record, @Param("example") GuideExample example);

    int updateByExample(@Param("record") Guide record, @Param("example") GuideExample example);

    int updateByPrimaryKeySelective(Guide record);

    int updateByPrimaryKey(Guide record);
}