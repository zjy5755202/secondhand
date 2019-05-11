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
    public void addGoodsDetails(GoodsDetails goodsDetails) {
         goodsDetailsDao.addGoodsDetails(goodsDetails);
    }

    @Override
    public void deleteGoodsDetailsById(int goodsId) {
         goodsDetailsDao.deleteGoodsDetailsByid(goodsId);
    }

    @Override
    public void updateGoodsDetails(GoodsDetails goodsDetails) {
         goodsDetailsDao.updateGoodsDetails(goodsDetails);
    }

    @Override
    public GoodsDetails queryGoodsDetailsById(int goodsId) {
        return goodsDetailsDao.queryGoodsDetailsById(goodsId);
    }
}
