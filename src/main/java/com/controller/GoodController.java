package com.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.Good;
import com.redis.Redis;
import com.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Good")
public class GoodController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private Redis redis;

    //根据标题搜索Goods
    @RequestMapping("/queryGoodByTitle")
    @ResponseBody
    public List<Good> queryGoodByTitle(String title){
        List<Good> result=goodService.queryGoodByTitle(title);
        return result;
    }
    //查看某个用户收藏的Goods
    @RequestMapping("/queryUserCollectionGood")
    @ResponseBody
    public List<Good> queryUserCollectionGood(String uuid){
        List<Good> result=goodService.queryUserCollectionGood(uuid);
        return result;
    }
    //查看某个用户发布的Goods
    @RequestMapping("/queryUserPublishGoods")
    @ResponseBody
    public List<Good> queryUserPublishGoods(String uuid){
        List<Good> result=goodService.queryUserPublishGoods(uuid);
        return result;
    }
    //根据goodid来搜索Good
    @RequestMapping("/queryGoodById")
    @ResponseBody
    public Good queryGoodById(String goodid){
        Good result=goodService.queryGoodById(goodid);
        return result;
    }
    //删除一个Good
    @RequestMapping("/deleteGood")
    public void deleteGood(String goodid){
        goodService.deleteGood(goodid);
    }
    //上传一个Good
    @RequestMapping("/addGood")
    public void addGood(String jsonstr){
        Good good = JSON.parseObject(jsonstr, new TypeReference<Good>() {});
        goodService.addGood(good);
    }
    //更新一个Good
    @RequestMapping("/updateGood")
    public void updateGood(@RequestBody String jsonstr){
        Good good = JSON.parseObject(jsonstr, new TypeReference<Good>() {});
        String str=JSON.toJSONString(good);
        System.out.println("-------------后端对象--------------");
        System.out.println(str);
        //goodService.updateGood(good);
    }
    //点开查看详情的时候会调用的，查询这个good的remarks和Details
    @RequestMapping("/queryGoodDetails")
    public Good queryGoodDetails(String goodid){
        Good result=goodService.queryGoodDetailsById(goodid);
        return result;
    }



}
