package com.entity;


public class SupplyDetails {
    private String supplyid;
    private String imgs;
    private String description;
    private int collections;
    private String contact;

    public String getSupplyid() {
        return supplyid;
    }

    public void setSupplyid(String supplyid) {
        this.supplyid = supplyid;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
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
}
