package com.LiteTravel.web.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    DEFAULT_ERROR(2000, "服务器出现了些小问题, 稍后再试试^_^"),
    BLOG_NOT_FOUND(2001, "你所找的文章不见了,要不换一个试试?"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何文章或评论进行回复!"),
    NO_LOGIN(2003, "未登陆, 请登陆后重试操作!"),
    TYPE_PARAM_WRONG(2004,"评论类型错误, 或不存在!"),
    COMMENT_NOT_FOUND(2005, "您想要评论的回复已经不存在了!"),
    CONTENT_IS_EMPTY(2006, "输入内容不能为空!")
    ;
    private Integer code;
    public String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}