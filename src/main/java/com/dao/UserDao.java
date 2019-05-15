package com.dao;

import com.entity.User;

public interface UserDao {
    //增加
    int addUser(User user);
    //更新
    int updateUser(User user);
    //查找
    User queryUserById(String id);
    //查找拥有者
    User queryGoodsOwner(int goodsid);
    //查找拥有者
    User querySupplyOwner(int supplyid);
}
