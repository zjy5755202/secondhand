package com.entity;


import java.sql.Timestamp;
import java.util.Date;

public class GoodsDetails {
    private int goodsid;
    private String images;
    private String description;
    private int collections;
    private String contact;
    private Timestamp createAt;

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
