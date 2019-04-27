package com.dao;

import com.entity.Goods;

import java.util.List;

public interface GoodsDao {
    //根据Title查询Goods
     List<Goods> queryGoodsByName(String name);
    //查看某个用户收藏的Goods
     List<Goods> queryUserCollectionGoods(String username);
    //查看某个用户发布的Goods
     List<Goods> queryUserPublishGoods(String username);
    //根据goodid来搜索Good
    Goods queryGoodsById(String goodsid);
    //删除一个Good
     void deleteGoods(String goodsid);
    //上传一个Good
     void addGoods(Goods goods);
    //更新一个Good
     void updateGoods(Goods goods);
    //点开查看详情的时候会调用的，查询这个good的remarks和Details
    Goods queryGoodsDetailsById(String goodsid);
}
