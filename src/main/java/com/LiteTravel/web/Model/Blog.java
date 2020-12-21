package com.LiteTravel.web.Model;

import java.util.Date;

public class Blog {
    private Integer blogId;

    private String blogTitle;

    private Date blogPostTime;

    private Date blogModifyTime;

    private Integer blogPosterId;

    private String blogImgUri;

    private Integer blogLikeCount;

    private Integer blogCommentCount;

    private String blogContent;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public Date getBlogPostTime() {
        return blogPostTime;
    }

    public void setBlogPostTime(Date blogPostTime) {
        this.blogPostTime = blogPostTime;
    }

    public Date getBlogModifyTime() {
        return blogModifyTime;
    }

    public void setBlogModifyTime(Date blogModifyTime) {
        this.blogModifyTime = blogModifyTime;
    }

    public Integer getBlogPosterId() {
        return blogPosterId;
    }

    public void setBlogPosterId(Integer blogPosterId) {
        this.blogPosterId = blogPosterId;
    }

    public String getBlogImgUri() {
        return blogImgUri;
    }

    public void setBlogImgUri(String blogImgUri) {
        this.blogImgUri = blogImgUri == null ? null : blogImgUri.trim();
    }

    public Integer getBlogLikeCount() {
        return blogLikeCount;
    }

    public void setBlogLikeCount(Integer blogLikeCount) {
        this.blogLikeCount = blogLikeCount;
    }

    public Integer getBlogCommentCount() {
        return blogCommentCount;
    }

    public void setBlogCommentCount(Integer blogCommentCount) {
        this.blogCommentCount = blogCommentCount;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}