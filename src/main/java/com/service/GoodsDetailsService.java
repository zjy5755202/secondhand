package com.service;


import com.entity.GoodsDetails;

public interface GoodsDetailsService {
    //增加一个供需
    void addGoodsDetails(GoodsDetails goodDetails);
    //删除一个供需
    void deleteGoodsDetailsById(int id);
    //更新一个供需
    void updateGoodsDetails(GoodsDetails supply);
    //查找一个供需
    GoodsDetails queryGoodsDetailsById(int goodsid);
}
