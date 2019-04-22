package com.service;

import com.entity.Supply;
import com.entity.SupplyDetails;

import java.util.List;

public interface SupplyService {
    //根据Title查询Supply
    List<Supply> querySupplyByTitle(String title);
    //查看某个用户收藏的Supply
    List<Supply> queryUserCollectionSupply(String userid);
    //查看某个用户发布的Supply
    List<Supply> queryUserPublishSupply(String userid);
    //根据goodid来搜索Supply
    Supply querySupplyById(String supplyid);
    //删除一个Supply
    void deleteSupply(String supplyid);
    //上传一个Supply
    void addSupply(Supply supply);
    //更新一个Supply
    void updateSupply(Supply supply);
    //点开查看详情的时候会调用的，查询这个SupplyDetails
    SupplyDetails querySupplyDetails(String supplyid);
}
