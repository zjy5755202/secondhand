package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    //增加
    int addUser(User user);
    //更新
    int updateUser(User user);
    //查找
    User queryById(String id);
    //查找
    User queryGoodsOwner(int goodsid);
    //查找
    User querySupplyOwner(int supplyid);
}
