package com.dao;


import com.entity.GoodsDetails;

public interface GoodsDetailsDao {
    //增加一个二手商品详情
    void addGoodsDetails(GoodsDetails goodsDetails);
    //删除一个二手商品详情
    void deleteGoodsDetailsByid(int goodsid);
    //更新一个二手商品详情
    void updateGoodsDetails(GoodsDetails goodsDetails);
    //查找一个二手商品详情
    GoodsDetails queryGoodsDetailsById(int goodsid);
}
