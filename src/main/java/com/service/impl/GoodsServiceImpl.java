package com.service.impl;


import com.dao.GoodsDao;
import com.entity.Goods;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;


    @Override
    public List<Goods> queryGoodsByTime() {
        List<Goods> result=goodsDao.queryGoodsByTime();
        return result;
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        List<Goods> result=goodsDao.queryGoodsByName(name);
        return result;
    }

    @Override
    public List<Goods> queryUserCollectionGoods(String username) {
        List<Goods> result=goodsDao.queryUserCollectionGoods(username);
        return result;
    }

    @Override
    public List<Goods> queryUserPublishGoods(String username) {
        List<Goods> result=goodsDao.queryUserPublishGoods(username);
        return result;
    }

    @Override
    public Goods queryGoodsById(int goodsid) {
        Goods result=goodsDao.queryGoodsById(goodsid);
        return result;
    }

    @Override
    public void deleteGoods(int goodsid) {
        goodsDao.deleteGoods(goodsid);
    }

    @Override
    public void addGoods(Goods good) {
        goodsDao.addGoods(good);
    }

    @Override
    public void updateGoods(Goods good) {
        goodsDao.updateGoods(good);
    }

//    @Override
//    public GoodsDetails queryGoodsDetailsById(String goodid) {
//        GoodsDetails result=goodsDao.queryGoodsDetailsById(goodid);
//        return result;
//    }
}
