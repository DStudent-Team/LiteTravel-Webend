package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.BlogDTO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.BlogMapper;
import com.LiteTravel.web.mapper.BlogTagMapMapper;
import com.LiteTravel.web.mapper.TagMapper;
import com.LiteTravel.web.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BlogTagMapMapper blogTagMapMapper;

    @Autowired
    private TagMapper tagMapper;
    @Cacheable(cacheNames = {"blog"}, key = "#blogId")
    public BlogDTO selectByPrimaryId(Integer blogId){
        Blog blog = blogMapper.selectByPrimaryKey(blogId);
        return getBlogDTO(blog);
    }

    public List<BlogDTO> selectAll() {
        List<Blog> blogs = blogMapper.selectByExample(new BlogExample());
        return blogs.stream().map(this::getBlogDTO).collect(Collectors.toList());
    }

    private BlogDTO getBlogDTO(Blog blog) {

        BlogDTO blogDTO = new BlogDTO();
        BeanUtils.copyProperties(blog, blogDTO);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(blog.getBlogPosterId());
        blogDTO.setBlogPosterInfo(userInfo);
        BlogTagMapExample blogTagMapExample = new BlogTagMapExample();
        blogTagMapExample.createCriteria()
                .andBlogIdEqualTo(blog.getBlogId());
        List<BlogTagMap> blogTagMapList = blogTagMapMapper.selectByExample(blogTagMapExample);
        if(blogTagMapList.size() > 0) {
            List<Integer> tagIds = blogTagMapList.stream().map(BlogTagMap::getTagId).distinct().collect(Collectors.toList());
            TagExample tagExample = new TagExample();
            tagExample.createCriteria()
                    .andTagIdIn(tagIds);
            List<Tag> tagList = tagMapper.selectByExample(tagExample);
            blogDTO.setBlogTags(tagList);
        }
        return blogDTO;
    }

    public int insertBlog(String title, String blog_text, int id){

        Blog blog = new Blog();
        blog.setBlogImgUri("image_1.jpg");
        blog.setBlogTitle(title);
        blog.setBlogContent(blog_text);
        blog.setBlogModifyTime(new Date());
        blog.setBlogPostTime(new Date());
        blog.setBlogCommentCount(0);
        blog.setBlogLikeCount(0);
        blog.setBlogPosterId(id);
        return blogMapper.insert(blog);
    }
}
