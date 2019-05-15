package com.entity;


import java.sql.Timestamp;

public class SupplyDetails {
    private int supplyid;
    private String images;
    private String description;
    private int collections;
    private String contact;
    private Timestamp createAt;
    private String owneravatar;
    private String ownernickname;

    public int getSupplyid() {
        return supplyid;
    }

    public void setSupplyid(int supplyid) {
        this.supplyid = supplyid;
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
}
