package com.service.impl;

import com.dao.GoodsDetailsDao;
import com.dao.SupplyCollectionDao;
import com.entity.SupplyCollection;
import com.service.SupplyCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplyCollectionServiceImpl implements SupplyCollectionService {
    @Autowired
    private SupplyCollectionDao supplyCollectionDao;
    @Override
    public void Star(SupplyCollection supplyCollection) {
        supplyCollectionDao.Star(supplyCollection);
    }

    @Override
    public void UnStar(SupplyCollection supplyCollection) {
        supplyCollectionDao.UnStar(supplyCollection);
    }
}
