package com.service;

import com.entity.Good;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface GoodService {
    //根据Title查询Good
     List<Good> queryGoodByTitle(String title);
    //查看某个用户收藏的Goods
     List<Good> queryUserCollectionGood(String username);
    //查看某个用户发布的Goods
     List<Good> queryUserPublishGoods(String username);
    //根据goodid来搜索Good
     Good queryGoodById(String goodid);
    //删除一个Good
     void deleteGood(String goodid);
    //上传一个Good
     void addGood(Good good);
    //更新一个Good
     void updateGood(Good good);
    //点开查看详情的时候会调用的，查询这个good的remarks和Details
     Good queryGoodDetailsById(String goodid);
}
