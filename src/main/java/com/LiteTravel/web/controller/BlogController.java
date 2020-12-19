package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Blog.BlogDTO;
import com.LiteTravel.web.DTO.Blog.BlogQueryDTO;
import com.LiteTravel.web.DTO.Blog.CommentDTO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.Blog;
import com.LiteTravel.web.Model.BlogExample;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.service.BlogService;
import com.LiteTravel.web.service.CommentService;
import com.LiteTravel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @GetMapping("/blogs")
    public String getBlogs(@RequestParam(value = "page",defaultValue = "1") Integer page, ModelMap model){
        setBlogPage(page, model);
        return "blogs";
    }
    private void setBlogPage(Integer page, ModelMap model){
        ResultVO result = blogService.selectAll(page, 6);
        model.addAttribute("blogs",result.data);
        model.addAttribute("pageInfo", result.info);
    }
    @GetMapping("/blog/{blogId}")
    public String BlogInfoPage(@PathVariable("blogId") Integer blogId,
                               ModelMap model){
        BlogDTO blog = blogService.getBlogById(blogId);
        UserInfo userInfo = userService.selectInfoByUserId(blog.getBlogPosterId());
        //获取回复信息
        List<CommentDTO> comments = commentService.listByBlogId(blogId);
        //获取推荐博客信息
        ResultVO recentBlogs = blogService.getBlogs(blogId, 1, 3);
        // todo 获取推荐标签海
        model.addAttribute("blog", blog);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("comments", comments);
        model.addAttribute("recentBlogs", recentBlogs.data);
        return "blog-single";
    }

    /**
     * 跳转到博客发布页面进行编辑博客
     * @return
     */
    @GetMapping("/blog/publish")
    public String ToBlogPublish(){
        return "blog-publish";
    }

    @PostMapping("/publish")
    public String publish(@PathParam("blogTitle") String blogTitle,
                          @PathParam("blogContent") String blogContent,
                          @PathParam("blogTags") String blogTags,
                          HttpSession session){
        UserDTO user = (UserDTO) session.getAttribute("user");
        blogService.insertBlog(blogTitle, blogContent, blogTags, user.userId);
        return "redirect:/blogs";
    }

    /***
     * 转入编辑博客页面
     * @param blogId
     * @param model
     * @return
     */
    @GetMapping("/blog/publish/{blogId}")
    public String toEditPage(@PathVariable("blogId") Integer blogId, ModelMap model){
        BlogDTO blog = blogService.getBlogById(blogId);
        model.addAttribute("blog",blog);
        return "blog-publish";
    }

    //在springboot2.0后，需要配置spring.mvc.hiddenmethod.enabled = true(默认为false), put和delete请求才能生效
    @PutMapping("/publish")
    public String updateBlog(@PathParam("blogId") Integer blogId,
                             @PathParam("blogTitle") String blogTitle,
                             @PathParam("blogContent") String blogContent,
                             @PathParam("blogTags") String blogTags){
        blogService.updateBlog(blogId, blogTitle, blogContent, blogTags);
        return "redirect:/blog/" + blogId;
    }


    @DeleteMapping("/blog/{blogId}")
    public String deleteBlog(@PathVariable("blogId") Integer blogId) {
        blogService.deleteBlogById(blogId);
        return "redirect:/blogs";
    }

    @PostMapping("/blogs")
    public String blogSearchList(@RequestParam(value = "page",defaultValue = "1") Integer page, ModelMap model,
                                 BlogQueryDTO blogQueryDTO) {
        setBlogPage(page, model, blogQueryDTO);
        return "blogs";
    }

    /* 用户使用的博客关键字查询 */
    private void setBlogPage(Integer page, ModelMap model, BlogQueryDTO blogQueryDTO){
        ResultVO result = blogService.selectByExample(page, 6, blogService.getBlogs(blogQueryDTO));
        model.addAttribute("blogs",result.data);
        model.addAttribute("pageInfo", result.info);
        model.addAttribute("search", blogQueryDTO);
    }
}
