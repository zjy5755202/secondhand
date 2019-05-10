package com.entity;

public class GoodsCollection {
    private String userid;
    private int goodsid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public GoodsCollection(String userid, int goodsid) {
        this.userid = userid;
        this.goodsid = goodsid;
    }
}
