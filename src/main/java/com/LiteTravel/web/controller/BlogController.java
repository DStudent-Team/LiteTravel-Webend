package com.LiteTravel.web.controller;

import com.LiteTravel.web.mapper.BlogMapper;
import com.LiteTravel.web.po.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogMapper blogMapper;
    @PostMapping("/forum")
    public String getForum(ModelMap model){
//        List<Blog> blogList = blogMapper.getAllBlog();
        return "blog";
    }

}
