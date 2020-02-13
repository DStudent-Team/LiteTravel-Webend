package com.LiteTravel.web.controller;

import com.LiteTravel.web.mapper.BlogMapper;
import com.LiteTravel.web.po.Blog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogMapper blogMapper;

    @GetMapping(value = "/blogs")
    public String getBlogs(ModelMap model){
        setBlogPage(1, model);
        return "blogs";
    }

    @GetMapping(value = "/blogs/{page}")
    public String getBlogs(@PathVariable(value = "page") Integer page, ModelMap model){
        setBlogPage(page, model);
        return "blogs";
    }
    private void setBlogPage(Integer page, ModelMap model){
        PageHelper.startPage(page, 6);
        List<Blog> blogs = blogMapper.getAllBlog();
        PageInfo<Blog> info = new PageInfo<>(blogs, 5);

        model.addAttribute("blogs",blogs);
        System.out.println(blogs.size());
        for (Blog blog: blogs
             ) {
            System.out.println(blog.toString());
        }
        model.addAttribute("pageInfo", info);
    }
}
