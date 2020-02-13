package com.LiteTravel.web.po;

import java.util.Date;
import java.util.List;

public class Blog {
    public Integer blogId;
    public String blogTitle;
    public Date blogPostTime;
    public Integer blogPosterId;
    public String blogPosterName;
    public Integer blogLikeCount;
    public Integer blogCommentNum;
    public String blogImgUri;
    public List<String> blogTags;

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogPostTime=" + blogPostTime +
                ", blogPosterId=" + blogPosterId +
                ", blogPosterName='" + blogPosterName + '\'' +
                ", blogLikeCount=" + blogLikeCount +
                ", blogCommentNum=" + blogCommentNum +
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

    public Integer getBlogCommentNum() {
        return blogCommentNum;
    }

    public void setBlogCommentNum(Integer blogCommentNum) {
        this.blogCommentNum = blogCommentNum;
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
