package com.LiteTravel.web.Model;

import java.util.Date;

public class Guide {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_guide.guide_id
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    private Integer guideId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_guide.user_id
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_guide.guide_from
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    private String guideFrom;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_guide.guide_to
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    private String guideTo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_guide.create_time
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_guide.guide_id
     *
     * @return the value of travel_guide.guide_id
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public Integer getGuideId() {
        return guideId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_guide.guide_id
     *
     * @param guideId the value for travel_guide.guide_id
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_guide.user_id
     *
     * @return the value of travel_guide.user_id
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_guide.user_id
     *
     * @param userId the value for travel_guide.user_id
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_guide.guide_from
     *
     * @return the value of travel_guide.guide_from
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public String getGuideFrom() {
        return guideFrom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_guide.guide_from
     *
     * @param guideFrom the value for travel_guide.guide_from
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public void setGuideFrom(String guideFrom) {
        this.guideFrom = guideFrom == null ? null : guideFrom.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_guide.guide_to
     *
     * @return the value of travel_guide.guide_to
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public String getGuideTo() {
        return guideTo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_guide.guide_to
     *
     * @param guideTo the value for travel_guide.guide_to
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public void setGuideTo(String guideTo) {
        this.guideTo = guideTo == null ? null : guideTo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_guide.create_time
     *
     * @return the value of travel_guide.create_time
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_guide.create_time
     *
     * @param createTime the value for travel_guide.create_time
     *
     * @mbg.generated Mon Dec 21 17:35:48 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}