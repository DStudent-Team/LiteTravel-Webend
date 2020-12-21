package com.LiteTravel.web.Model;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer parentType;

    private Integer parentId;

    private Date commentPostTime;

    private Date commentModifyTime;

    private Integer commentPosterId;

    private Integer commentLikeCount;

    private String commentContent;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getParentType() {
        return parentType;
    }

    public void setParentType(Integer parentType) {
        this.parentType = parentType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCommentPostTime() {
        return commentPostTime;
    }

    public void setCommentPostTime(Date commentPostTime) {
        this.commentPostTime = commentPostTime;
    }

    public Date getCommentModifyTime() {
        return commentModifyTime;
    }

    public void setCommentModifyTime(Date commentModifyTime) {
        this.commentModifyTime = commentModifyTime;
    }

    public Integer getCommentPosterId() {
        return commentPosterId;
    }

    public void setCommentPosterId(Integer commentPosterId) {
        this.commentPosterId = commentPosterId;
    }

    public Integer getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(Integer commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}