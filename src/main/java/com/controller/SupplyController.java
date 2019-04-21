package com.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.Good;
import com.entity.Supply;
import com.redis.Redis;
import com.service.GoodService;
import com.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Supply")
public class SupplyController {

    @Autowired
    private SupplyService supplyService;
    @Autowired
    private Redis redis;

    //根据title搜索supply
    @RequestMapping("/querySupplyByTitle")
    @ResponseBody
    public List<Supply> querySupplyByTitle(String title){
        return null;
    }
    //搜索某用户的supply收藏
    @RequestMapping("/queryUserCollectionSupply")
    public List<Supply> queryUserCollectionSupply(String uuid){
        String username=redis.get(uuid);
        return supplyService.queryUserCollectionSupply(username);
    }
    //搜索某用户发布的supply
    @RequestMapping("/queryUserPublishSupply")
    @ResponseBody
    public List<Supply> queryUserPublishSupply(String uuid){
        String username=redis.get(uuid);
        return supplyService.queryUserPublishSupply(username);
    }
    //根据supplyid搜索supply
    @RequestMapping("/querySupplyById")
    @ResponseBody
    public Supply querySupplyById(String supplyid){
        return supplyService.querySupplyById(supplyid);
    }
    //删除某个supply
    @RequestMapping("/deleteSupply")
    public void deleteSupply(String supplyid){
        supplyService.deleteSupply(supplyid);
    }
    //增加一个supply
    @RequestMapping("/addSupply")
    public void addSupply(String jsonstr){
        Supply supply = JSON.parseObject(jsonstr, new TypeReference<Supply>() {});
        supplyService.addSupply(supply);
    }
    //根性一个supply
    @RequestMapping("/updateSupply")
    public void updateSupply(String jsonstr){
        Supply supply = JSON.parseObject(jsonstr, new TypeReference<Supply>() {});
        supplyService.updateSupply(supply);
    }

}
