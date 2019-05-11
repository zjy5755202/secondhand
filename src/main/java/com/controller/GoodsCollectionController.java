package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.entity.GoodsCollection;
import com.redis.Redis;
import com.service.GoodsCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/GoodsCollection")
public class GoodsCollectionController {
    @Autowired
    private Redis redis;
    @Autowired
    private GoodsCollectionService goodsCollectionService;

    @RequestMapping("/Star")
    @ResponseBody
    public void Star(@RequestBody String jsonstr){
//        JSONObject object=(JSONObject) JSON.parse(jsonstr);
//        String tempuserid=(String)object.get("userid");
//        String userid=redis.get(tempuserid);
//        int goodsid=(int)object.get("goodsid");
//        goodsCollectionService.Star(new GoodsCollection(userid,goodsid));


        //测试使用的代码
        GoodsCollection goodsCollection = JSON.parseObject(jsonstr, new TypeReference<GoodsCollection>() {});
        goodsCollectionService.Star(goodsCollection);
    }

    @RequestMapping("/UnStar")
    @ResponseBody
    public void UnStar(@RequestBody String jsonstr){
//        JSONObject object=(JSONObject) JSON.parse(jsonstr);
//        String tempuserid=(String)object.get("userid");
//        String userid=redis.get(tempuserid);
//        int goodsid=(int)object.get("goodsid");
//        goodsCollectionService.UnStar(new GoodsCollection(userid,goodsid));

        //测试使用代码
        GoodsCollection goodsCollection = JSON.parseObject(jsonstr, new TypeReference<GoodsCollection>() {});
        goodsCollectionService.UnStar(goodsCollection);
    }

}
