// todo 旅行社推出的旅行线路po, 属性还会被修改, 为了暂时测试用而设计
package com.LiteTravel.web.po;

public class Line {
    public Integer id;
    public String name;
    public String description;
    public Integer peopleCount;
    public Integer full;
    public String price;
    public Integer agencyID;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getFull() {
        return full;
    }

    public void setFull(Integer full) {
        this.full = full;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Integer agencyID) {
        this.agencyID = agencyID;
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", peopleCount=" + peopleCount +
                ", full=" + (full==1?"满":"未满") +
                ", price='" + price + '\'' +
                ", agencyID=" + agencyID +
                '}';
    }
}
