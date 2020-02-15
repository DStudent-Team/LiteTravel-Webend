package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Blog;

import java.util.List;

public interface BlogMapper {
    public List<Blog> getAllBlog();
    public Blog getBlog(Integer blogId);
    public void insertBlog(Blog blog);
}
