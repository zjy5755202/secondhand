package com.entity;

import java.util.Date;

public class Supply {
    //唯一标识supply的supplyid 作为主键
    private String supplyid;
    //标明发布者的id 作为外键
    private String userid;
    //供需主图的url
    private String cover;
    //供需主题
    private String title;
    //薪酬
    private double price;
    //发布时间
    private Date createAt;
    //过期时间
    private Date expire;
    //该需求的详情
    private SupplyDetails supplyDetails;

    public String getSupplyid() {
        return supplyid;
    }

    public void setSupplyid(String supplyid) {
        this.supplyid = supplyid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public SupplyDetails getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(SupplyDetails supplyDetails) {
        this.supplyDetails = supplyDetails;
    }


}
