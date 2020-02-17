package com.LiteTravel.web.DTO;

import com.LiteTravel.web.Model.Tag;
import com.LiteTravel.web.Model.UserInfo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BlogDTO {
    private Integer blogId;
    private String blogTitle;
    private Date blogPostTime;
    private Date blogModifyTime;
    private Integer blogPosterId;
    private UserInfo blogPosterInfo;
    private String blogImgUri;
    private Integer blogLikeCount;
    private Integer blogCommentCount;
    private String blogContent;
    private List<Tag> blogTags;
}
