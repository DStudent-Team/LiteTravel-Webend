package com.LiteTravel.web.Model;

import lombok.Data;
import lombok.ToString;

@Data
public class Tag {
    public String tagId;
    public String tagName;

    @Override
    public String toString() {
        return tagName;
    }
}
