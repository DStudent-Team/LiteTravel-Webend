package com.LiteTravel.web.DTO.Blog;

import lombok.Data;

import java.util.Date;

@Data
public class BlogQueryDTO {
    String keyword;
    private Date startModifyTime;
    private Date endModifyTime;
    private Integer userId;
    /* 通过前端标签选择框返回的tagId */
    private Integer tagId;

    @Override
    public String toString() {
        return "BlogQueryDTO{" +
                "keyword='" + keyword + '\'' +
                ", startModifyTime=" + startModifyTime +
                ", endModifyTime=" + endModifyTime +
                ", userId=" + userId +
                ", tagId=" + tagId +
                '}';
    }
}
