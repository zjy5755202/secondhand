package com.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Supply {
    //唯一标识supply的supplyid 作为主键
    private int supplyid;
    //标明发布者的id 作为外键
    private String userid;
    //供需主图的url
    private String cover;
    //供需主题
    private String title;
    //薪酬
    private double price;
    //发布时间
    private Timestamp createAt;
    //过期时间
    private Timestamp expires;
    //该需求的详情
    private SupplyDetails supplyDetails;

    public int getSupplyid() {
        return supplyid;
    }

    public void setSupplyid(int supplyid) {
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getExpires() {
        return expires;
    }

    public void setExpires(Timestamp expires) {
        this.expires = expires;
    }

    public SupplyDetails getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(SupplyDetails supplyDetails) {
        this.supplyDetails = supplyDetails;
    }


}
