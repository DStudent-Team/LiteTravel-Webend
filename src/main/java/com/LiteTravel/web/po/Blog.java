package com.LiteTravel.web.po;

import java.util.Date;
import java.util.List;

public class Blog {
    public Integer blogId;
    public String blogTitle;
    public Date blogPostTime;
    public Integer blogPosterId;
    public String blogPosterName;


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

}
