package com.service.impl;


import com.dao.GoodDao;
import com.entity.Good;
import com.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao goodDao;


    @Override
    public List<Good> queryGoodByTitle(String title) {
        List<Good> result=goodDao.queryGoodByTitle(title);
        return result;
    }

    @Override
    public List<Good> queryUserCollectionGood(String username) {
        List<Good> result=goodDao.queryUserCollectionGood(username);
        return result;
    }

    @Override
    public List<Good> queryUserPublishGoods(String username) {
        List<Good> result=goodDao.queryUserPublishGoods(username);
        return result;
    }

    @Override
    public Good queryGoodById(String goodid) {
        Good result=goodDao.queryGoodById(goodid);
        return result;
    }

    @Override
    public void deleteGood(String goodid) {
        goodDao.deleteGood(goodid);
    }

    @Override
    public void addGood(Good good) {
        goodDao.addGood(good);
    }

    @Override
    public void updateGood(Good good) {
        goodDao.updateGood(good);
    }

    @Override
    public Good queryGoodDetailsById(String goodid) {
        Good result=goodDao.queryGoodDetailsById(goodid);
        return result;
    }
}
