package com.LiteTravel.web.Model;

import java.util.Date;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog_comment.comment_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Integer commentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog_comment.parent_type
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Integer parentType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog_comment.parent_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog_comment.comment_post_time
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Date commentPostTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog_comment.comment_modify_time
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Date commentModifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog_comment.comment_poster_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Integer commentPosterId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog_comment.comment_like_count
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Integer commentLikeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_blog_comment.comment_content
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private String commentContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog_comment.comment_id
     *
     * @return the value of travel_blog_comment.comment_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog_comment.comment_id
     *
     * @param commentId the value for travel_blog_comment.comment_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog_comment.parent_type
     *
     * @return the value of travel_blog_comment.parent_type
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Integer getParentType() {
        return parentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog_comment.parent_type
     *
     * @param parentType the value for travel_blog_comment.parent_type
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setParentType(Integer parentType) {
        this.parentType = parentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog_comment.parent_id
     *
     * @return the value of travel_blog_comment.parent_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog_comment.parent_id
     *
     * @param parentId the value for travel_blog_comment.parent_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog_comment.comment_post_time
     *
     * @return the value of travel_blog_comment.comment_post_time
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Date getCommentPostTime() {
        return commentPostTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog_comment.comment_post_time
     *
     * @param commentPostTime the value for travel_blog_comment.comment_post_time
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setCommentPostTime(Date commentPostTime) {
        this.commentPostTime = commentPostTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog_comment.comment_modify_time
     *
     * @return the value of travel_blog_comment.comment_modify_time
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Date getCommentModifyTime() {
        return commentModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog_comment.comment_modify_time
     *
     * @param commentModifyTime the value for travel_blog_comment.comment_modify_time
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setCommentModifyTime(Date commentModifyTime) {
        this.commentModifyTime = commentModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog_comment.comment_poster_id
     *
     * @return the value of travel_blog_comment.comment_poster_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Integer getCommentPosterId() {
        return commentPosterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog_comment.comment_poster_id
     *
     * @param commentPosterId the value for travel_blog_comment.comment_poster_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setCommentPosterId(Integer commentPosterId) {
        this.commentPosterId = commentPosterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog_comment.comment_like_count
     *
     * @return the value of travel_blog_comment.comment_like_count
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Integer getCommentLikeCount() {
        return commentLikeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog_comment.comment_like_count
     *
     * @param commentLikeCount the value for travel_blog_comment.comment_like_count
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setCommentLikeCount(Integer commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_blog_comment.comment_content
     *
     * @return the value of travel_blog_comment.comment_content
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_blog_comment.comment_content
     *
     * @param commentContent the value for travel_blog_comment.comment_content
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}