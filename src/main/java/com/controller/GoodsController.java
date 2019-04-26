package com.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.Goods;
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

    //根据标题搜索Goods
    @RequestMapping("/queryGoodByTitle")
    @ResponseBody
    public List<Goods> queryGoodByTitle(String title){
        List<Goods> result=goodsService.queryGoodsByTitle(title);
        return result;
    }
    //查看某个用户收藏的Goods
    @RequestMapping("/queryUserCollectionGoods")
    @ResponseBody
    public List<Goods> queryUserCollectionGood(String uuid){
        List<Goods> result=goodsService.queryUserCollectionGoods(uuid);
        return result;
    }
    //查看某个用户发布的Goods
    @RequestMapping("/queryUserPublishGoods")
    @ResponseBody
    public List<Goods> queryUserPublishGoods(String uuid){
        List<Goods> result=goodsService.queryUserPublishGoods(uuid);
        return result;
    }
    //根据goodid来搜索Good
    @RequestMapping("/queryGoodsById")
    @ResponseBody
    public Goods queryGoodsById(@RequestBody String jsonstr){
        String goodsid=(String)JSON.parse(jsonstr);
        Goods result=goodsService.queryGoodsById(goodsid);
        return result;
    }
    //删除一个Good
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public void deleteGoods(@RequestBody String jsonstr){
        String goodsid=(String)JSON.parse(jsonstr);
        goodsService.deleteGoods(goodsid);
    }
    //上传一个Good
    @RequestMapping("/addGoods")
    @ResponseBody
    public void addGoods(@RequestBody String jsonstr){
        Goods goods = JSON.parseObject(jsonstr, new TypeReference<Goods>() {});
        String str=JSON.toJSONString(goods);
        goodsService.addGoods(goods);
    }
    //更新一个Good
    @RequestMapping("/updateGoods")
    @ResponseBody
    public void updateGoods(@RequestBody String jsonstr){
        Goods goods = JSON.parseObject(jsonstr, new TypeReference<Goods>() {});
        String str=JSON.toJSONString(goods);
        goodsService.updateGoods(goods);
    }
    //点开查看详情的时候会调用的，查询这个good的remarks和Details
    @RequestMapping("/queryGoodsDetails")
    @ResponseBody
    public Goods queryGoodsDetails(String goodsid){
        Goods result=goodsService.queryGoodsDetailsById(goodsid);
        return result;
    }



}
