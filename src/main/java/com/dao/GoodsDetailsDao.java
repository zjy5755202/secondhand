package com.dao;


import com.entity.GoodsDetails;

public interface GoodsDetailsDao {
    //增加一个二手商品详情
    int addGoodsDetails(GoodsDetails goodsDetails);
    //删除一个二手商品详情
    int deleteGoodsDetailsById(String goodsid);
    //更新一个二手商品详情
    int updateGoodsDetails(GoodsDetails goodsDetails);
    //查找一个二手商品详情
    GoodsDetails queryGoodsDetailsById(String goodsid);
}
