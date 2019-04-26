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

    @RequestMapping("/addSupplyDetails")
    public void addSupplyDetails(@RequestBody String jsonstr) throws IOException {
        SupplyDetails supplyDetails = JSON.parseObject(jsonstr, new TypeReference<SupplyDetails>() {});
        supplyDetailsService.addSupplyDetails(supplyDetails);
    }

    @RequestMapping("/updateSupplyDetails")
    public void updateSupplyDetails(@RequestBody String jsonstr) throws IOException {
        SupplyDetails supplyDetails = JSON.parseObject(jsonstr, new TypeReference<SupplyDetails>() {});
        supplyDetailsService.addSupplyDetails(supplyDetails);
    }


    @RequestMapping("/querySupplyDetailsByid")
    @ResponseBody
    public  SupplyDetails querySupplyDetailsByid(String suuplyid) throws IOException {
        SupplyDetails result=supplyDetailsService.querySupplyDetailsById(suuplyid);
        return result;
    }

    @RequestMapping("/deleteSupplyDetailsByid")
    public void deleteSupplyDetailsByid(String supplyid) throws IOException {
        supplyDetailsService.deleteSupplyDetailsById(supplyid);
    }
}
