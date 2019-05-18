package com.service;

import com.entity.Goods;

import java.util.List;

public interface GoodsService {
    //根据时间选取一定Goods
    List<Goods> queryGoodsByTime();
    //根据Title查询Good
     List<Goods> queryGoodsByName(String name);
    //查看某个用户收藏的Goods
     List<Goods> queryUserCollectionGoods(String username);
    //查看某个用户发布的Goods
     List<Goods> queryUserPublishGoods(String username);
    //根据goodid来搜索Good
    Goods queryGoodsById(int goodsid);
    //删除一个Good
     void deleteGoods(int goodsid);
    //上传一个Good
     void addGoods(Goods good);
    //更新一个Good
     void updateGoods(Goods good);
//    //点开查看详情的时候会调用的，查询这个good的remarks和Details
//    GoodsDetails queryGoodsDetailsById(String goodid);
}
