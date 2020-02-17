package com.LiteTravel.web.enums;

public enum CommentTypeEnum {
    Blog(0),
    COMMENT(1);
    private Integer type;

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type){
        this.type = type;
    }
//    检测回复类型是否存在
    public static boolean isExist(Integer type){
        for (CommentTypeEnum commentTypeEnum: CommentTypeEnum.values()) {
            if(commentTypeEnum.getType().equals(type))
                return true;
        }
        return false;
    }
}
