/*
* 酒店概览信息表
* 用于酒店的列表展示, 地址信息仍需要做些许修改
* todo 需要对地址内容进行跟进
* */
package com.LiteTravel.web.Model;

public class Hotel {
    public Integer hotelId;
    public String hotelName;
    public Integer hotelMinPrice;
    public String hotelPhone;
    public Integer hotelLevel;
    public String hotelDescription;
    public String hotelAddress;
    public String hotelImgUri;
    public Integer hotelCommentCount;
    // 需要添加评论概览数据?
    //
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getHotelMinPrice() {
        return hotelMinPrice;
    }

    public void setHotelMinPrice(Integer hotelMinPrice) {
        this.hotelMinPrice = hotelMinPrice;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public Integer getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Integer hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelImgUri() {
        return hotelImgUri;
    }

    public void setHotelImgUri(String hotelImgUri) {
        this.hotelImgUri = hotelImgUri;
    }

    public Integer getHotelCommentCount() {
        return hotelCommentCount;
    }

    public void setHotelCommentCount(Integer hotelCommentCount) {
        this.hotelCommentCount = hotelCommentCount;
    }

}
