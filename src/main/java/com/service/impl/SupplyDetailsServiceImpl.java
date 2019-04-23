package com.service.impl;


import com.dao.SupplyDetailsDao;
import com.entity.SupplyDetails;
import com.service.SupplyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplyDetailsServiceImpl implements SupplyDetailsService {
    @Autowired
    private SupplyDetailsDao supplyDetailsDao;

    @Override
    public int addSupplyDetails(SupplyDetails supplyDetails) {

        return supplyDetailsDao.addSupplyDetails(supplyDetails);
    }

    @Override
    public int deleteSupplyDetailsById(String supplyid) {
        return supplyDetailsDao.deleteSupplyDetailsById(supplyid);
    }

    @Override
    public int updateSupplyDetails(SupplyDetails supplyDetails) {
        return supplyDetailsDao.updateSupplyDetails(supplyDetails);
    }

    @Override
    public SupplyDetails querySupplyDetailsById(String supplyid) {
        return supplyDetailsDao.querySupplyDetailsById(supplyid);
    }
}
