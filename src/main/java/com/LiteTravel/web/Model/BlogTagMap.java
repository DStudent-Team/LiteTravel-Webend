package com.LiteTravel.web.Model;

public class BlogTagMap {
    private Integer blogId;

    private Integer tagId;

    private Integer tagLike;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getTagLike() {
        return tagLike;
    }

    public void setTagLike(Integer tagLike) {
        this.tagLike = tagLike;
    }
}