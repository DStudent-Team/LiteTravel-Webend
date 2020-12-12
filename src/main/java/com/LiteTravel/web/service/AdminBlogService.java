package com.LiteTravel.web.service;

import com.LiteTravel.web.Model.Blog;
import com.LiteTravel.web.Model.BlogExample;
import com.LiteTravel.web.mapper.BlogMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xiaobai
 * @Date 2020/12/11 7:32
 * @Version 1.0
 */
@Service
public class AdminBlogService {

    @Autowired
    private BlogMapper blogMapper;

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






}
