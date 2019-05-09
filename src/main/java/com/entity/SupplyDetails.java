package com.entity;


public class SupplyDetails {
    private int supplyid;
    private String images;
    private String description;
    private int collections;
    private String contact;

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
}
