package com.LiteTravel.web.po;

public class Tag {
    public String tagId;
    public String tagName;

    @Override
    public String toString() {
        return tagName;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
