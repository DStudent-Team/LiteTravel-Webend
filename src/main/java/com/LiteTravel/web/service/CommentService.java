package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.CommentDTO;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.enums.CommentTypeEnum;
import com.LiteTravel.web.exception.CustomizeErrorCode;
import com.LiteTravel.web.exception.CustomizeException;
import com.LiteTravel.web.mapper.BlogExtMapper;
import com.LiteTravel.web.mapper.BlogMapper;
import com.LiteTravel.web.mapper.CommentMapper;
import com.LiteTravel.web.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    public CommentMapper commentMapper;

    @Autowired
    public BlogMapper blogMapper;

    @Autowired
    public BlogExtMapper blogExtMapper;

    @Autowired
    public UserInfoMapper userInfoMapper;

    @Transactional
    public void insert(Comment comment){
//        检测父类Id是否正常
        if(comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
//        检测父类类型是否增长
        if(comment.getParentType() == null || !CommentTypeEnum.isExist(comment.getParentType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
//        检测父级对象是否存在
        if(comment.getParentType().equals(CommentTypeEnum.COMMENT.getType())){
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if(dbComment == null)
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            commentMapper.insert(comment);
        }
        else {
            Blog dbBlog = blogMapper.selectByPrimaryKey(comment.getParentId());
            if(dbBlog == null)
                throw new CustomizeException(CustomizeErrorCode.BLOG_NOT_FOUND);
            commentMapper.insert(comment);
            Blog blog = new Blog();
            blog.setBlogId(dbBlog.getBlogId());
            blog.setBlogCommentCount(1);
            blogExtMapper.incCommentCount(blog);
        }
    }
    // 若要缓存的话, 要考虑如何将新写入的信息插入缓存内容中
    public List<CommentDTO> listByBlogId(Integer blogId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria()
                .andParentIdEqualTo(blogId)
                .andParentTypeEqualTo(CommentTypeEnum.Blog.getType());
        commentExample.setOrderByClause("comment_modify_time DESC");
        List<Comment> comments = commentMapper.selectByExampleWithBLOBs(commentExample);
        /* 若无回复则直接返回空 */
        if(comments.size() == 0)
            return new ArrayList<>();
        /* 获得所有的UserId, 去掉重复的 */
        Set<Integer> posters = comments.stream().map(Comment::getCommentPosterId).collect(Collectors.toSet());
        List<Integer> userIds = new ArrayList<>(posters);
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria()
                .andUserIdIn(userIds);
        /* 获取所有回复人的UserInfo */
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        /* 用Map来存储UserInfo 避免重复保存, 以及快速取得*/
        Map<Integer, UserInfo> infoMap = userInfos.stream().collect(Collectors.toMap(UserInfo::getUserId, info -> info));
        /* 通过Lambda语法以及BeanUtils极速简化代码量 */
        return comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTO.setUserInfo(infoMap.get(comment.getCommentPosterId()));
            return commentDTO;
        }).collect(Collectors.toList());

    }
}
