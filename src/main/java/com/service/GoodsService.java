package com.service;

import com.entity.Goods;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface GoodsService {
    //根据Title查询Good
     List<Goods> queryGoodsByTitle(String title);
    //查看某个用户收藏的Goods
     List<Goods> queryUserCollectionGoods(String username);
    //查看某个用户发布的Goods
     List<Goods> queryUserPublishGoods(String username);
    //根据goodid来搜索Good
    Goods queryGoodsById(String goodid);
    //删除一个Good
     void deleteGoods(String goodid);
    //上传一个Good
     void addGoods(Goods good);
    //更新一个Good
     void updateGoods(Goods good);
    //点开查看详情的时候会调用的，查询这个good的remarks和Details
    Goods queryGoodsDetailsById(String goodid);
}
