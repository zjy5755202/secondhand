package com.dao;


import com.entity.GoodDetails;

public interface GoodDetailsDao {
    //增加一个供需
    int addGoodDetails(GoodDetails good);
    //删除一个供需
    int deleteGoodDetailsById(String id);
    //更新一个供需
    int updateGoodDetails(GoodDetails supply);
    //查找一个供需
    GoodDetails queryGoodDetailsById(String id);
}
