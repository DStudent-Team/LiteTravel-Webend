package com.LiteTravel.web.DTO;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public class ResultVO implements Serializable {
    public List data;
    public PageInfo info;

    public ResultVO(List data, PageInfo info){
        this.setData(data);
        this.setPageInfo(info);
    }

    private void setPageInfo(PageInfo info) {
        this.info = info;
    }

    private void setData(List data){
        this.data = data;
    }
}
