package com.service;

import com.entity.Supply;
import com.entity.SupplyDetails;

public interface SupplyDetailsService {
    //增加一个供需
    int addSupplyDetails(SupplyDetails supplyDetails);
    //删除一个供需
    int deleteSupplyDetailsById(String supplyid);
    //更新一个供需
    int updateSupplyDetails(SupplyDetails supplyDetails);
    //查找一个供需
    SupplyDetails querySupplyDetailsById(String supplyid);
}
