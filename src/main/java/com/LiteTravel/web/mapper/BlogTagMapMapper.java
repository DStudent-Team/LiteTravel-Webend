package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.BlogTagMap;
import com.LiteTravel.web.Model.BlogTagMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogTagMapMapper {
    long countByExample(BlogTagMapExample example);

    int deleteByExample(BlogTagMapExample example);

    int insert(BlogTagMap record);

    int insertSelective(BlogTagMap record);

    List<BlogTagMap> selectByExample(BlogTagMapExample example);

    int updateByExampleSelective(@Param("record") BlogTagMap record, @Param("example") BlogTagMapExample example);

    int updateByExample(@Param("record") BlogTagMap record, @Param("example") BlogTagMapExample example);
}