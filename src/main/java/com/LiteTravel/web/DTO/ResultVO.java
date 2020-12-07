package com.LiteTravel.web.DTO;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public class ResultVO<T> implements Serializable {
    public List<T> resultList;
    public PageInfo<T> info;

    public ResultVO(List<T> data, PageInfo<T> info){
        this.setResultList(data);
        this.setPageInfo(info);
    }

    private void setPageInfo(PageInfo<T> info) {
        this.info = info;
    }

    private void setResultList(List<T> data){
        this.resultList = data;
    }
}
