package com.LiteTravel.web.Model;

import java.util.Date;
import java.util.List;

public class Blog {
    public Integer blogId;
    public String blogTitle;
    public Date blogPostTime;
    public Date blogModifyTime;
    public String blogContent;
    public Integer blogPosterId;
    public String blogPosterName;
    public Integer blogLikeCount;
    public Integer blogCommentCount;/* 为了性能, 牺牲一些可能的不同步, 设计为在回复后自增的设定*/
    public String blogImgUri;
    public List<String> blogTags;

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogPostTime=" + blogPostTime +
                ", blogModifyTime=" + blogModifyTime +
                ", blogContent='" + blogContent + '\'' +
                ", blogPosterId=" + blogPosterId +
                ", blogPosterName='" + blogPosterName + '\'' +
                ", blogLikeCount=" + blogLikeCount +
                ", blogCommentCount=" + blogCommentCount +
                ", blogImgUri='" + blogImgUri + '\'' +
                ", blogTags=" + blogTags +
                '}';
    }

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
        this.blogTitle = blogTitle;
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

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Integer getBlogPosterId() {
        return blogPosterId;
    }

    public void setBlogPosterId(Integer blogPosterId) {
        this.blogPosterId = blogPosterId;
    }

    public String getBlogPosterName() {
        return blogPosterName;
    }

    public void setBlogPosterName(String blogPosterName) {
        this.blogPosterName = blogPosterName;
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

    public String getBlogImgUri() {
        return blogImgUri;
    }

    public void setBlogImgUri(String blogImgUri) {
        this.blogImgUri = blogImgUri;
    }

    public List<String> getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(List<String> blogTags) {
        this.blogTags = blogTags;
    }
}
