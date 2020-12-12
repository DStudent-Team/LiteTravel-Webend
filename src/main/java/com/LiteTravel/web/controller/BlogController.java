package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Blog.BlogDTO;
import com.LiteTravel.web.DTO.Blog.CommentDTO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.UserInfo;
import com.LiteTravel.web.service.BlogService;
import com.LiteTravel.web.service.CommentService;
import com.LiteTravel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        BlogDTO blog = blogService.selectByPrimaryId(blogId);
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
    public String publish(@PathParam("title") String title,
                          @PathParam("blog_text") String blog_text,
                          @PathParam("blog_tags") String blog_tags,
                          HttpSession session){
        UserDTO user = (UserDTO) session.getAttribute("user");
        blogService.insertBlog(title, blog_text, blog_tags, user.userId);
        return "redirect:/blogs";
    }
}
