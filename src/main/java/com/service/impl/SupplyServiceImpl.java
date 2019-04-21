package com.service.impl;

import com.dao.SupplyDao;
import com.dao.UserDao;
import com.entity.Supply;
import com.entity.User;
import com.service.SupplyService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    private SupplyDao supplyDao;

    @Override
    public List<Supply> querySupplyByTitle(String title) {
        List<Supply> result=supplyDao.querySupplyByTitle(title);
        return result;
    }

    @Override
    public List<Supply> queryUserCollectionSupply(String username) {
        List<Supply> result=supplyDao.queryUserCollectionSupply(username);
        return result;
    }

    @Override
    public List<Supply> queryUserPublishSupply(String username) {
        List<Supply> result=supplyDao.queryUserPublishSupply(username);
        return result;
    }

    @Override
    public Supply querySupplyById(String supplyid) {
        Supply result=supplyDao.querySupplyById(supplyid);
        return result;
    }

    @Override
    public void deleteSupply(String supplyid) {
        supplyDao.deleteSupply(supplyid);
    }

    @Override
    public void addSupply(Supply supply) {
        supplyDao.addSupply(supply);
    }

    @Override
    public void updateSupply(Supply supply) {
        supplyDao.updateSupply(supply);
    }

    @Override
    public Supply querySupplyDetails(String supplyid) {
        Supply result=supplyDao.querySupplyDetails(supplyid);
        return result;
    }
}
