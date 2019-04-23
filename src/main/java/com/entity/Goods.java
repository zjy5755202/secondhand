package com.entity;

import java.util.Date;

public class Goods {
    //唯一标识good的goodsid 作为主键
    private String goodsid;
    //标明发布者的id 作为外键
    private String userid;
    //商品主图的url
    private String cover;
    //商品名称
    private String name;
    //商品价格
    private double price;
    //发布时间
    private Date createAt;
    //该商品的详情
    private GoodsDetails goodsDetails;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public GoodsDetails getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(GoodsDetails goodsDetails) {
        this.goodsDetails = goodsDetails;
    }
}