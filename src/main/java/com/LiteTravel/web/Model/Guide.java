package com.LiteTravel.web.Model;

import java.util.Date;

public class Guide {
    private Integer guideId;

    private Integer userId;

    private String guideFrom;

    private String guideTo;

    private Date createTime;

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGuideFrom() {
        return guideFrom;
    }

    public void setGuideFrom(String guideFrom) {
        this.guideFrom = guideFrom == null ? null : guideFrom.trim();
    }

    public String getGuideTo() {
        return guideTo;
    }

    public void setGuideTo(String guideTo) {
        this.guideTo = guideTo == null ? null : guideTo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}