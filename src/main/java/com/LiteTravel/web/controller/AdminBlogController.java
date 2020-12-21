package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Blog.BlogQueryDTO;
import com.LiteTravel.web.Model.Blog;
import com.LiteTravel.web.service.AdminBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author xiaobai
 * @Date 2020/12/11 9:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin")
public class AdminBlogController {

    @Autowired
    AdminBlogService adminBlogService;

    /**
     * 1. 只需要发送/admin/blogs?pageNum=1&pageSize=6,就可以获取到数据 1和6要自己改变
     * 2. model传输的对象，在视图层直接使用:${blogs}即可获取数据
     * 3. /admin/blog: 要跳转的页面，自定义(我不知道实际的页面)
     *
     * 分页查找博客
     *
     * @param page int
     * @param model model
     * @return String
     */
    @GetMapping("/manage/blogs")
    public String toAdmin(@RequestParam(value = "page",defaultValue = "1") Integer page, ModelMap model){
        List<Blog> blogs = adminBlogService.getBlogs(page, 6);
        model.addAttribute("blogs", blogs);
        return "/blogs/list";
    }

    @PostMapping("/manage/blogs")
    public String getBlogs(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            BlogQueryDTO blogQueryDTO,
                            ModelMap model) {
        List<Blog> blogs = adminBlogService.getBlogs(page, 6, blogQueryDTO);
        model.addAttribute("blogs", blogs);
        return "/blogs/list";
    }

    /**
     * 1. 发送一个/manage/update的post请求，提交一个包含博客更改信息的表单的数据(id必须有，通过隐藏)
     *
     * 如果更新成功，重定向到博客列表
     *
     * @param blog 博客
     * @return int
     */
    @PostMapping("/manage/blog")
    public String updateBlog(Blog blog, Model model){
        adminBlogService.updateBlog(blog);
        model.addAttribute("message", "更新成功");
        return "redirect:/blogs/list";
    }

    /**
     *  1. 发送一个/admin/delete/id的Get请求，可以删除博客
     *
     * @param id 博客id
     * @return 跳转页面
     */
    @DeleteMapping("/manage/blog")
    public String deleteBlog(@PathVariable("id") Integer id, Model model){
        int flag = adminBlogService.deleteBlogById(id);
        model.addAttribute("message", "删除成功");
        return "redirect:/blogs/list";
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
