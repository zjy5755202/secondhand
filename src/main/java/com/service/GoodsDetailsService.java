package com.service;


import com.entity.GoodsDetails;

public interface GoodsDetailsService {
    //增加一个供需
    int addGoodsDetails(GoodsDetails goodDetails);
    //删除一个供需
    int deleteGoodsDetailsById(String id);
    //更新一个供需
    int updateGoodsDetails(GoodsDetails supply);
    //查找一个供需
    GoodsDetails queryGoodsDetailsById(String goodsid);
}
