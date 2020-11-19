package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BlogExtMapper {
    public void incCommentCount(Blog blog);
}
