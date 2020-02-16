package com.LiteTravel.web.service;

import com.LiteTravel.web.Model.Blog;
import com.LiteTravel.web.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public Blog selectByPrimaryId(Integer blogId){
        return blogMapper.getBlog(blogId);
    }

    public List<Blog> selectAll() {
        return blogMapper.getAllBlog();
    }
}
