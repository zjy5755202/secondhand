package com.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.Goods;
import com.entity.GoodsDetails;
import com.redis.Redis;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private Redis redis;

    //首页加载的时候按照时间来挑选一定的goods
    @RequestMapping("/queryGoodsByTime")
    @ResponseBody
    public List<Goods> queryGoodsByTime(){
        List<Goods> result=goodsService.queryGoodsByTime();
        return result;
    }

    //根据标题搜索Goods
    //代码完毕 已测试 待调试
    @RequestMapping("/queryGoodsByName")
    @ResponseBody
    public List<Goods> queryGoodsByName(@RequestBody String jsonstr){
        String name=(String)JSON.parse(jsonstr);
        List<Goods> result=goodsService.queryGoodsByName(name);
        return result;
    }

    //查看某个用户收藏的Goods
    //代码完毕 未测试 待调试
    @RequestMapping("/queryUserCollectionGoods")
    @ResponseBody
    public List<Goods> queryUserCollectionGoods(@RequestBody String jsonstr){
        String tempuserid=(String)JSON.parse(jsonstr);
        String userid=redis.get(tempuserid);
        List<Goods> result=goodsService.queryUserCollectionGoods(userid);
        return result;
    }

    //查看某个用户发布的Goods
    //代码完毕 未测试 待调试
    @RequestMapping("/queryUserPublishGoods")
    @ResponseBody
    public List<Goods> queryUserPublishGoods(@RequestBody String jsonstr){
        String tempuserid=(String)JSON.parse(jsonstr);
        String userid=redis.get(tempuserid);
        List<Goods> result=goodsService.queryUserPublishGoods(userid);
        return result;
    }

    //根据goodid来搜索Good
    //代码完毕 已测试 待调试
    @RequestMapping("/queryGoodsById")
    @ResponseBody
    public Goods queryGoodsById(@RequestBody String jsonstr){
        String goodsid=(String)JSON.parse(jsonstr);
        Goods result=goodsService.queryGoodsById(goodsid);
        return result;
    }

    //删除一个Good
    //代码完毕 已测试 待调试
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public void deleteGoods(@RequestBody String jsonstr){
        String goodsid=(String)JSON.parse(jsonstr);
        goodsService.deleteGoods(goodsid);
    }

    //上传一个Good
    //代码完毕 已测试 待调试
    @RequestMapping("/addGoods")
    @ResponseBody
    public void addGoods(@RequestBody String jsonstr){
        Goods goods = JSON.parseObject(jsonstr, new TypeReference<Goods>() {});
        goodsService.addGoods(goods);
    }

    //更新一个Good
    //代码完毕 已测试 待调试
    @RequestMapping("/updateGoods")
    @ResponseBody
    public void updateGoods(@RequestBody String jsonstr){
        Goods goods = JSON.parseObject(jsonstr, new TypeReference<Goods>() {});
        goodsService.updateGoods(goods);
    }

    //点开查看详情的时候会调用的，查询这个goods的Details
    //代码完毕 未测试 待调试
    @RequestMapping("/queryGoodsDetails")
    @ResponseBody
    public Goods queryGoodsDetails(@RequestBody String jsonstr){
        String goodsid=(String)JSON.parse(jsonstr);
        GoodsDetails goodsDetails=goodsService.queryGoodsDetailsById(goodsid);
        Goods result=goodsService.queryGoodsById(goodsid);
        result.setGoodsDetails(goodsDetails);
        return result;
    }



}
