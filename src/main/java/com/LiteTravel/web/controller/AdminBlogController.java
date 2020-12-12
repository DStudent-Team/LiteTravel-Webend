package com.LiteTravel.web.controller;

import com.LiteTravel.web.Model.Blog;
import com.LiteTravel.web.service.AdminBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @Author xiaobai
 * @Date 2020/12/11 9:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin")
public class AdminBlogController {

    @Autowired
    private AdminBlogService adminBlogService;

    /**
     * 1. 只需要发送/admin/blogs?pageNum=1&pageSize=6,就可以获取到数据 1和6要自己改变
     * 2. model传输的对象，在视图层直接使用:${blogs}即可获取数据
     * 3. /admin/blog: 要跳转的页面，自定义(我不知道实际的页面)
     *
     * 分页查找博客
     *
     * @param pageNum int
     * @param pageSize int
     * @param model model
     * @return String
     */
    @GetMapping("/blogs")
    public String toAdmin(@PathParam("pageNum") Integer pageNum, @PathParam("pageSize") Integer pageSize, Model model){
        model.addAttribute("blogs", adminBlogService.listBlog(pageNum, pageSize));
        return "/admin/blog";
    }

    /**
     * 1. ${blog}为原始数据
     * 2. 发送/admin/toUpdate/id的Get请求，就可以获取要更新的所有信息(旧的)
     *
     * 跳转到更新页面
     * @param id 博客id
     * @return 跳转到更新页面
     */
    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        model.addAttribute("blog", adminBlogService.getBlog(id));
        return "update_blog";
    }

    /**
     * 1. 发送一个/admin/update的post请求，提交一个包含博客更改信息的表单的数据(id必须有，通过隐藏)
     *
     * 如果更新成功，重定向到博客列表
     * 如果更新失败，跳回/toUpdate
     *
     * @param blog 博客
     * @return int
     */
    @PostMapping("/update")
    public String updateBlog(Blog blog, Model model){
        int flag = adminBlogService.updateBlog(blog);
        if (flag == 1) {
            model.addAttribute("message", "更新成功");
            return "redirect:/admin/blogs";
        }else{
            model.addAttribute("message", "更新失败");
            return "/admin/toUpdate";
        }
    }

    /**
     *  1. 发送一个/admin/delete/id的Get请求，可以删除博客
     *
     * @param id 博客id
     * @return 跳转页面
     */
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Integer id, Model model){
        int flag = adminBlogService.deleteBlogById(id);
        if (flag == 1){
            model.addAttribute("message", "删除成功");
        }else{
            model.addAttribute("message", "删除失败");
        }
        return "redirect:/admin/blogs";
    }

    /**
     * 通过id查找博客，根据需要，看要不要咯
     *
     * @param id 博客id
     * @param model model
     */
    @GetMapping("/blog/{id}")
    public void getBlogById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("blog", adminBlogService.getBlog(id));
    }
}
