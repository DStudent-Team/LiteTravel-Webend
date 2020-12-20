package com.LiteTravel.web.Model;

import java.util.Date;

public class Blog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog.blog_id
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    private Integer blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog.blog_title
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    private String blogTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog.blog_post_time
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    private Date blogPostTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog.blog_modify_time
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    private Date blogModifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog.blog_poster_id
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    private Integer blogPosterId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog.blog_img_uri
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    private String blogImgUri;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog.blog_like_count
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    private Integer blogLikeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog.blog_comment_count
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    private Integer blogCommentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog.blog_content
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    private String blogContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog.blog_id
     *
     * @return the value of travel_blog.blog_id
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public Integer getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog.blog_id
     *
     * @param blogId the value for travel_blog.blog_id
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog.blog_title
     *
     * @return the value of travel_blog.blog_title
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public String getBlogTitle() {
        return blogTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog.blog_title
     *
     * @param blogTitle the value for travel_blog.blog_title
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog.blog_post_time
     *
     * @return the value of travel_blog.blog_post_time
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public Date getBlogPostTime() {
        return blogPostTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog.blog_post_time
     *
     * @param blogPostTime the value for travel_blog.blog_post_time
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public void setBlogPostTime(Date blogPostTime) {
        this.blogPostTime = blogPostTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog.blog_modify_time
     *
     * @return the value of travel_blog.blog_modify_time
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public Date getBlogModifyTime() {
        return blogModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog.blog_modify_time
     *
     * @param blogModifyTime the value for travel_blog.blog_modify_time
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public void setBlogModifyTime(Date blogModifyTime) {
        this.blogModifyTime = blogModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog.blog_poster_id
     *
     * @return the value of travel_blog.blog_poster_id
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public Integer getBlogPosterId() {
        return blogPosterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog.blog_poster_id
     *
     * @param blogPosterId the value for travel_blog.blog_poster_id
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public void setBlogPosterId(Integer blogPosterId) {
        this.blogPosterId = blogPosterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog.blog_img_uri
     *
     * @return the value of travel_blog.blog_img_uri
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public String getBlogImgUri() {
        return blogImgUri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog.blog_img_uri
     *
     * @param blogImgUri the value for travel_blog.blog_img_uri
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public void setBlogImgUri(String blogImgUri) {
        this.blogImgUri = blogImgUri == null ? null : blogImgUri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog.blog_like_count
     *
     * @return the value of travel_blog.blog_like_count
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public Integer getBlogLikeCount() {
        return blogLikeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog.blog_like_count
     *
     * @param blogLikeCount the value for travel_blog.blog_like_count
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public void setBlogLikeCount(Integer blogLikeCount) {
        this.blogLikeCount = blogLikeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog.blog_comment_count
     *
     * @return the value of travel_blog.blog_comment_count
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public Integer getBlogCommentCount() {
        return blogCommentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog.blog_comment_count
     *
     * @param blogCommentCount the value for travel_blog.blog_comment_count
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public void setBlogCommentCount(Integer blogCommentCount) {
        this.blogCommentCount = blogCommentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog.blog_content
     *
     * @return the value of travel_blog.blog_content
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public String getBlogContent() {
        return blogContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog.blog_content
     *
     * @param blogContent the value for travel_blog.blog_content
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}