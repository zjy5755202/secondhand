package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.SupplyCollection;
import com.redis.Redis;
import com.service.SupplyCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/SupplyCollection")
public class SupplyCollectionController {
    @Autowired
    private Redis redis;
    @Autowired
    private SupplyCollectionService supplyCollectionService;

    @RequestMapping("/Star")
    @ResponseBody
    public void Star(@RequestBody String jsonstr){
        JSONObject object=(JSONObject) JSON.parse(jsonstr);
        String tempuserid=(String)object.get("userid");
        String userid=redis.get(tempuserid);
        int supplyid=(int)object.get("goodsid");
        supplyCollectionService.Star(new SupplyCollection(userid,supplyid));
    }

    @RequestMapping("/Unstar")
    @ResponseBody
    public void UnStar(@RequestBody String jsonstr){
        JSONObject object=(JSONObject) JSON.parse(jsonstr);
        String tempuserid=(String)object.get("userid");
        String userid=redis.get(tempuserid);
        int supplyid=(int)object.get("goodsid");
        supplyCollectionService.UnStar(new SupplyCollection(userid,supplyid));
    }

}
