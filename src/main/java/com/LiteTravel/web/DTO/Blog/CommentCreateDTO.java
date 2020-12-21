package com.LiteTravel.web.DTO.Blog;

import lombok.Data;

@Data
public class CommentCreateDTO {
    public Integer parentId;
    public String commentContent;
    public Integer parentType;
}
