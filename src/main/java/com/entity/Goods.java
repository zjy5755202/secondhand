package com.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Goods {
    //唯一标识good的goodsid 作为主键
    private int goodsid;
    //标明发布者的id 作为外键
    private String userid;
    //商品主图的url
    private String cover;
    //商品名称
    private String name;
    //商品价格
    private double price;
    //发布时间
    private Timestamp createAt;

    //改动
    private String owneravatar;
    private String ownernickname;
    private String contact;
    private int collections;

//    //该商品的详情
//    private GoodsDetails goodsDetails;

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public String getOwneravatar() {
        return owneravatar;
    }

    public void setOwneravatar(String owneravatar) {
        this.owneravatar = owneravatar;
    }

    public String getOwnernickname() {
        return ownernickname;
    }

    public void setOwnernickname(String ownernickname) {
        this.ownernickname = ownernickname;
    }

    public int getCollections() {
        return collections;
    }

    public void setCollections(int collections) {
        this.collections = collections;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    //    public GoodsDetails getGoodsDetails() {
//        return goodsDetails;
//    }
//
//    public void setGoodsDetails(GoodsDetails goodsDetails) {
//        this.goodsDetails = goodsDetails;
//    }
}
