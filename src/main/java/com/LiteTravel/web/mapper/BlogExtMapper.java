package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogExtMapper {
    public void incCommentCount(Blog blog);
}
