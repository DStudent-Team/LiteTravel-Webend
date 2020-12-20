package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.Blog.BlogDTO;
import com.LiteTravel.web.DTO.Blog.BlogQueryDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.Blog;
import com.LiteTravel.web.Model.BlogExample;
import com.LiteTravel.web.Model.BlogTagMap;
import com.LiteTravel.web.Model.BlogTagMapExample;
import com.LiteTravel.web.mapper.BlogMapper;
import com.LiteTravel.web.mapper.BlogTagMapMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author xiaobai
 * @Date 2020/12/11 7:32
 * @Version 1.0
 */
@Service
public class AdminBlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BlogTagMapMapper blogTagMapMapper;

    /**
     * 通过博客id删除博客
     * @param id 博客id
     * @return int
     */
    public int deleteBlogById(Integer id){
        return blogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 分页查询列表
     * @param pageNum 页数
     * @param pageSize 大小
     * @return 博客列表
     */
    public List<Blog> listBlog(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return blogMapper.selectByExample(new BlogExample());
    }

    /**
     * 通过id查找博客
     * @param id 博客id
     * @return 博客
     */
    public Blog getBlog(Integer id){
        return blogMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新博客
     * @param blog 更新后的博客内容
     * @return int
     */
    public int updateBlog(Blog blog){
        return blogMapper.updateByPrimaryKeySelective(blog);
    }


    /* 复合查询 */
    public List<Blog> getBlogs(Integer pageNum, Integer pageSize, BlogQueryDTO blogQueryDTO) {

        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria blogExampleCriteria = blogExample.createCriteria();
        /*关键字*/
        if (blogQueryDTO.getKeyword() != null) {
            blogExampleCriteria.andBlogTitleLike("%" + blogQueryDTO.getKeyword() + "%");
        }
        /*最近修改时间的起始时间*/
        if (blogQueryDTO.getStartModifyTime() != null) {
            blogExampleCriteria.andBlogModifyTimeGreaterThanOrEqualTo(blogQueryDTO.getStartModifyTime());
        }
        /*最近修改时间的终止时间*/
        if (blogQueryDTO.getEndModifyTime() != null) {
            blogExampleCriteria.andBlogModifyTimeLessThanOrEqualTo(blogQueryDTO.getEndModifyTime());
        }
        /* 发布者Id查询 */
        if (blogQueryDTO.getUserId() != null) {
            blogExampleCriteria.andBlogPosterIdEqualTo(blogQueryDTO.getUserId());
        }
        /* 单标签查询 */
        if (blogQueryDTO.getTagId() != null) {
            BlogTagMapExample blogTagMapExample = new BlogTagMapExample();
            blogTagMapExample.createCriteria().andTagIdEqualTo(blogQueryDTO.getTagId());
            List<BlogTagMap> blogTagMapList = blogTagMapMapper.selectByExample(blogTagMapExample);
            List<Integer> blogIds = blogTagMapList.stream().map(BlogTagMap::getBlogId).distinct().collect(Collectors.toList());
            blogExampleCriteria.andBlogIdIn(blogIds);
        }
        PageHelper.startPage(pageNum, pageSize);
        return blogMapper.selectByExample(blogExample);
    }






}
