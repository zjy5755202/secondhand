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
@RequestMapping("/Good")
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
    @RequestMapping("/queryUserCollectionGood")
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
    @RequestMapping("/queryGoodById")
    @ResponseBody
    public Goods queryGoodById(String goodsid){
        Goods result=goodsService.queryGoodsById(goodsid);
        return result;
    }
    //删除一个Good
    @RequestMapping("/deleteGood")
    public void deleteGood(String goodsid){
        goodsService.deleteGoods(goodsid);
    }
    //上传一个Good
    @RequestMapping("/addGood")
    public void addGood(String jsonstr){
        Goods good = JSON.parseObject(jsonstr, new TypeReference<Goods>() {});
        goodsService.addGoods(good);
    }
    //更新一个Good
    @RequestMapping("/updateGood")
    public void updateGood(@RequestBody String jsonstr){
        Goods good = JSON.parseObject(jsonstr, new TypeReference<Goods>() {});
        String str=JSON.toJSONString(good);
        System.out.println("-------------后端对象--------------");
        System.out.println(str);
        //goodService.updateGood(good);
    }
    //点开查看详情的时候会调用的，查询这个good的remarks和Details
    @RequestMapping("/queryGoodDetails")
    public Goods queryGoodDetails(String goodsid){
        Goods result=goodsService.queryGoodsDetailsById(goodsid);
        return result;
    }



}
