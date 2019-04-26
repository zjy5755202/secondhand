package com.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.Supply;
import com.redis.Redis;
import com.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
        String userId=redis.get(uuid);
        return supplyService.queryUserCollectionSupply(userId);
    }
    //搜索某用户发布的supply
    @RequestMapping("/queryUserPublishSupply")
    @ResponseBody
    public List<Supply> queryUserPublishSupply(String uuid){
        String userId=redis.get(uuid);
        return supplyService.queryUserPublishSupply(userId);
    }

    //根据supplyid搜索supply
    @RequestMapping("/querySupplyById")
    @ResponseBody
    public Supply querySupplyById(@RequestBody String jsonstr){
        String supplyid=(String)JSON.parse(jsonstr);
        return supplyService.querySupplyById(supplyid);
    }
    //删除某个supply
    @RequestMapping("/deleteSupply")
    @ResponseBody
    public void deleteSupply(@RequestBody String jsonstr){
        String supplyid=(String)JSON.parse(jsonstr);
        supplyService.deleteSupply(supplyid);
    }
    //增加一个supply
    @RequestMapping("/addSupply")
    @ResponseBody
    public void addSupply(@RequestBody String jsonstr){
        Supply supply = JSON.parseObject(jsonstr, new TypeReference<Supply>() {});
        System.out.print(supply);
        supplyService.addSupply(supply);
    }
    //根性一个supply
    @RequestMapping("/updateSupply")
    @ResponseBody
    public void updateSupply(@RequestBody String jsonstr){
        Supply supply = JSON.parseObject(jsonstr, new TypeReference<Supply>() {});
        System.out.print(supply);
        supplyService.updateSupply(supply);
    }

}
