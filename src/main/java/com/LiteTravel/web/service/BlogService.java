package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.Blog.BlogDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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

//    @Cacheable(cacheNames = {"blog"}, key = "#blogId")
    public BlogDTO getBlogById(Integer blogId){
        Blog blog = blogMapper.selectByPrimaryKey(blogId);
        return getBlogDTO(blog);
    }

    public ResultVO selectAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Blog> blogs = blogMapper.selectByExample(new BlogExample());
        PageInfo<Blog> info = new PageInfo<>(blogs, 5);
        List<BlogDTO> data = blogs.stream().map(this::getBlogDTO).collect(Collectors.toList());
        return new ResultVO(data, info);
    }

    public ResultVO getBlogs(Integer blogId, Integer page, Integer pageSize)
    {
        BlogExample blogExample = new BlogExample();
//      todo 推荐算法尚未写好
        blogExample.createCriteria()
                .andBlogIdNotEqualTo(blogId);
        return selectByExample(page, pageSize, blogExample);
    }

    private ResultVO selectByExample(Integer page, Integer pageSize, BlogExample blogExample){
        PageHelper.startPage(page, pageSize);
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        PageInfo<Blog> info = new PageInfo<>(blogs, 5);
        List<BlogDTO> data = blogs.stream().map(this::getBlogDTO).collect(Collectors.toList());
        return new ResultVO(data, info);
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


    @Transactional
    public int insertBlog(String blogTitle, String blogContent, String blogTags, int userId){
        Blog blog = new Blog();
        blog.setBlogImgUri("image_1.jpg");
        blog.setBlogTitle(blogTitle);
        blog.setBlogContent(blogContent);
        blog.setBlogModifyTime(new Date());
        blog.setBlogPostTime(new Date());
        blog.setBlogCommentCount(0);
        blog.setBlogLikeCount(0);
        blog.setBlogPosterId(userId);
        /*插入博客*/
        blogMapper.insert(blog);
        /*获取新插入的博客的Id*/
        int insertId = blog.getBlogId();
        /*获取tagNamesList*/
        insertTags(insertId, blogTags);
        return insertId;
    }

    /***
     * 更新tags和blog_tag_map的方法
     * @param blogId
     * @param blogTags
     */
    private void insertTags(Integer blogId, String blogTags){
        List<String> tagNames = Arrays.stream((blogTags.toLowerCase().replace(" ", "").split(","))).distinct().collect(Collectors.toList());

        TagExample tagExample = new TagExample();
        tagExample.createCriteria()
                .andTagNameIn(tagNames);
        List<Tag> oldTags = tagMapper.selectByExample(tagExample);
        /*插入原本就有的tag*/
        for (Tag oldTag: oldTags) {
            BlogTagMap blogTagMap = new BlogTagMap();
            blogTagMap.setBlogId(blogId);
            blogTagMap.setTagId(oldTag.getTagId());
            blogTagMap.setTagLike(0);
            blogTagMapMapper.insert(blogTagMap);
        }
        /*插入新的tag*/
        List<String> oldTagsName = oldTags.stream().map(Tag::getTagName).collect(Collectors.toList());
        tagNames.removeIf(oldTagsName::contains);
        for (String newTag:tagNames) {
            /*先插入新tag, 再将tagId与blogId对应着生成TagMap*/
            Tag tag = new Tag();
            tag.setTagName(newTag);
            tagMapper.insert(tag);
            BlogTagMap blogTagMap = new BlogTagMap();
            blogTagMap.setBlogId(blogId);
            blogTagMap.setTagId(tag.getTagId());
            blogTagMap.setTagLike(0);
            blogTagMapMapper.insert(blogTagMap);
        }
    }

    public void updateBlog(Integer blogId,
                           String blogTitle,
                           String blogContent,
                           String blogTags) {
        Blog blog = new Blog();
        blog.setBlogId(blogId);
        blog.setBlogTitle(blogTitle);
        blog.setBlogContent(blogContent);
        blogMapper.updateByPrimaryKeySelective(blog);
        if (blogTags != null){
            /*先删除旧的tags*/
            BlogTagMapExample blogTagMapExample = new BlogTagMapExample();
            blogTagMapExample.createCriteria()
                    .andBlogIdEqualTo(blogId);
            blogTagMapMapper.deleteByExample(blogTagMapExample);
            /*再更新新的tags*/
            insertTags(blogId, blogTags);
        }

    }

    public void deleteBlogById(Integer blogId) {
        BlogTagMapExample blogTagMapExample = new BlogTagMapExample();
        blogTagMapExample.createCriteria()
                .andBlogIdEqualTo(blogId);
        blogTagMapMapper.deleteByExample(blogTagMapExample);
        blogMapper.deleteByPrimaryKey(blogId);
    }
}
