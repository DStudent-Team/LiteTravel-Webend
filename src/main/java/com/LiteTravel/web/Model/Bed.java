package com.LiteTravel.web.Model;

import java.math.BigDecimal;

public class Bed {
    private Integer bedId;

    private String bedName;

    private BigDecimal bedSize;

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public String getBedName() {
        return bedName;
    }

    public void setBedName(String bedName) {
        this.bedName = bedName == null ? null : bedName.trim();
    }

    public BigDecimal getBedSize() {
        return bedSize;
    }

    public void setBedSize(BigDecimal bedSize) {
        this.bedSize = bedSize;
    }
}