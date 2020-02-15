package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.CommentDTO;
import com.LiteTravel.web.Model.Blog;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.service.BlogService;
import com.LiteTravel.web.service.CommentService;
import com.LiteTravel.web.service.UserService;
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
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
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
        List<Blog> blogs = blogService.selectAll();
        PageInfo<Blog> info = new PageInfo<>(blogs, 5);

        model.addAttribute("blogs",blogs);
        model.addAttribute("pageInfo", info);
    }
    @GetMapping("/blog/{blogId}")
    public String BlogInfoPage(@PathVariable("blogId") Integer blogId,
                               ModelMap model){
        Blog blog = blogService.selectByPrimaryId(blogId);
        UserInfo userInfo = userService.selectInfoByUserId(blog.blogPosterId);
//        todo 获取回复信息
        List<CommentDTO> comments = commentService.listByBlogId(blogId);
//        todo 获取推荐标签海
//        todo 获取推荐博客信息
        model.addAttribute("blog", blog);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("comments", comments);
        return "blog-single";
    }
}
