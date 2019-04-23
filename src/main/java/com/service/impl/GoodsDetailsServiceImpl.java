package com.service.impl;


import com.dao.GoodsDetailsDao;
import com.entity.GoodsDetails;
import com.service.GoodsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsDetailsServiceImpl implements GoodsDetailsService {
    @Autowired
    private GoodsDetailsDao goodsDetailsDao;


    @Override
    public int addGoodsDetails(GoodsDetails goodsDetails) {
        return goodsDetailsDao.addGoodsDetails(goodsDetails);
    }

    @Override
    public int deleteGoodsDetailsById(String goodsId) {
        return goodsDetailsDao.deleteGoodsDetailsById(goodsId);
    }

    @Override
    public int updateGoodsDetails(GoodsDetails goodsDetails) {
        return goodsDetailsDao.updateGoodsDetails(goodsDetails);
    }

    @Override
    public GoodsDetails queryGoodsDetailsById(String goodsId) {
        return goodsDetailsDao.queryGoodsDetailsById(goodsId);
    }
}
