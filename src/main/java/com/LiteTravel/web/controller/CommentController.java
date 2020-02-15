package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.CommentCreateDTO;
import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.exception.CustomizeErrorCode;
import com.LiteTravel.web.Model.Comment;
import com.LiteTravel.web.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("/blog/comment")
    @ResponseBody
    @Transactional
    public Object PostComment(@RequestBody CommentCreateDTO commentCreateDTO,
                              HttpSession session
                              ){
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        if(userDTO == null){
            return ResponseDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        /* 防内容为空 */
        if(commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getCommentContent()))
        {
            return ResponseDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }

//        写入数据
        Comment comment = new Comment();
        comment.setCommentPosterId(userDTO.getUserId());
        comment.setParentId(commentCreateDTO.parentId);
        comment.setParentType(commentCreateDTO.parentType);
        comment.setCommentContent(commentCreateDTO.getCommentContent());
        comment.setCommentPostTime(new Date());
        comment.setCommentModifyTime(new Date());
        comment.setCommentLikeCount(0);
        commentService.insert(comment);
//        返回信息
        return ResponseDTO.successOf();
    }
}
