package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.redis.Redis;
import com.service.UserService;
import com.util.UUIDGenerrator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user){
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user){
        return userDao.updateUser(user);
    }

    @Override
    public User queryById(String id) {
        return userDao.queryUserById(id);
    }

    @Override
    public User queryOwner(int goodsid) {
        return userDao.queryOwner(goodsid);
    }

}
