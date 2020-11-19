package com.LiteTravel.web.DTO;

import com.LiteTravel.web.Model.UserInfo;
import lombok.Data;

import java.util.Date;
@Data
public class CommentDTO {
    private Integer commentId;
    private Integer parentType;
    private Integer parentId;
    private Date commentPostTime;
    private Date commentModifyTime;
    private Integer commentPosterId;
    private Integer commentLikeCount;
    private String commentContent;
    private UserInfo userInfo;

    public void setUserInfo(UserInfo userInfo) {
    }
}
