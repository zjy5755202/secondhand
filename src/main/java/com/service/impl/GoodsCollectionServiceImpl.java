package com.service.impl;

import com.dao.GoodsCollectionDao;
import com.entity.GoodsCollection;
import com.service.GoodsCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsCollectionServiceImpl implements GoodsCollectionService {
    @Autowired
    private GoodsCollectionDao goodsCollectionDao;

    @Override
    public void Star(GoodsCollection goodsCollection) {
    goodsCollectionDao.Star(goodsCollection);
    }

    @Override
    public void UnStar(GoodsCollection goodsCollection) {
        goodsCollectionDao.UnStar(goodsCollection);
    }
}
