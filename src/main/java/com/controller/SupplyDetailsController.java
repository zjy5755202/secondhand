package com.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.SupplyDetails;
import com.entity.User;
import com.redis.Redis;
import com.service.SupplyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/SupplyDetails")
public class SupplyDetailsController {

    @Autowired
    private SupplyDetailsService supplyDetailsService;

    //代码完毕 未测试 待调试
    @RequestMapping("/addSupplyDetails")
    @ResponseBody
    public void addSupplyDetails(@RequestBody String jsonstr) throws IOException {
        SupplyDetails supplyDetails = JSON.parseObject(jsonstr, new TypeReference<SupplyDetails>() {});
        supplyDetailsService.addSupplyDetails(supplyDetails);
    }

    //代码完毕 未测试 待调试
    @RequestMapping("/updateSupplyDetails")
    @ResponseBody
    public void updateSupplyDetails(@RequestBody String jsonstr) throws IOException {
        SupplyDetails supplyDetails = JSON.parseObject(jsonstr, new TypeReference<SupplyDetails>() {});
        supplyDetailsService.updateSupplyDetails(supplyDetails);
    }

    //代码完毕 未测试 待调试
    @RequestMapping("/querySupplyDetailsById")
    @ResponseBody
    public  SupplyDetails querySupplyDetailsByid(@RequestBody String jsonstr) throws IOException {
        int supplyid=Integer.parseInt((String)JSON.parse(jsonstr));
        SupplyDetails result=supplyDetailsService.querySupplyDetailsById(supplyid);
        return result;
    }

    //代码完毕 未测试 待调试
    @RequestMapping("/deleteSupplyDetailsById")
    @ResponseBody
    public void deleteSupplyDetailsByid(@RequestBody String jsonstr) throws IOException {
        int supplyid=Integer.parseInt((String)JSON.parse(jsonstr));
        supplyDetailsService.deleteSupplyDetailsById(supplyid);
    }
}
