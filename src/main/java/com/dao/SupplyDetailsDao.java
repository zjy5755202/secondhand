package com.dao;

import com.entity.SupplyDetails;

public interface SupplyDetailsDao {
    //增加一个供需
    int addSupplyDetails(SupplyDetails supplyDetails);
    //删除一个供需
    int deleteSupplyDetailsById(int supplyid);
    //更新一个供需
    int updateSupplyDetails(SupplyDetails supplyDetails);
    //查找一个供需
    SupplyDetails querySupplyDetailsById(int supplyid);
}
