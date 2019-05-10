package com.dao;


import com.entity.GoodsCollection;

public interface GoodsCollectionDao {
    void Star(GoodsCollection goodsCollection);
    void UnStar(GoodsCollection goodsCollection);
}
