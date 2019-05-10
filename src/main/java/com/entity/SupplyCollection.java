package com.entity;

public class SupplyCollection {
    private String userid;
    private int supplyid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getSupplyid() {
        return supplyid;
    }

    public void setSupplyid(int supplyid) {
        this.supplyid = supplyid;
    }

    public SupplyCollection(String userid, int supplyid) {
        this.userid = userid;
        this.supplyid = supplyid;
    }
}
