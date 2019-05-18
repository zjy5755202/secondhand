package com.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.Goods;
import com.entity.Supply;
import com.entity.User;
import com.redis.Redis;
import com.service.SupplyService;
import com.service.UserService;
import com.util.UUIDGenerrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Supply")
public class SupplyController {

    @Autowired
    private SupplyService supplyService;
    @Autowired
    private UserService userService;
    @Autowired
    private Redis redis;

    private String coverPath ="D:\\softwarePro\\target\\secondhand\\supplyImg\\";


    //首页加载所需要的Supply
    //代码完毕 未测试 待调试
    @RequestMapping("/querySupplyByTime")
    @ResponseBody
    public List<Supply> querySupplyByTime(){
        List<Supply> result=supplyService.querySupplyByTime();
        return result;
    }

    //根据title搜索supply
    //代码完毕 未测试 待调试
    @RequestMapping("/querySupplyByTitle")
    @ResponseBody
    public List<Supply> querySupplyByTitle(@RequestBody String jsonstr){
        String title=(String)JSON.parse(jsonstr);
        List<Supply> result=supplyService.querySupplyByTitle(title);
        return result;
    }

    //搜索某用户的supply收藏
    //代码完毕 未测试 待调试
    @RequestMapping("/queryUserCollectionSupply")
    @ResponseBody
    public List<Supply> queryUserCollectionSupply(@RequestBody String jsonstr){
//        String tempuserid=(String)JSON.parse(jsonstr);
//        String userid=redis.get(tempuserid);
//        List<Supply> result=supplyService.queryUserCollectionSupply(userid);
//        return result;
        //测试用
        String userid=(String)JSON.parse(jsonstr);
        List<Supply> result=supplyService.queryUserCollectionSupply(userid);
        return result;
    }

    //搜索某用户发布的supply
    //代码完毕 未测试 待调试
    @RequestMapping("/queryUserPublishSupply")
    @ResponseBody
    public List<Supply> queryUserPublishSupply(@RequestBody String jsonstr){
//        String tempuserid=(String)JSON.parse(jsonstr);
//        String userid=redis.get(tempuserid);
//        List<Supply> result=supplyService.queryUserPublishSupply(userid);
//        return result;

        //测试用
        String userid=(String)JSON.parse(jsonstr);
        List<Supply> result=supplyService.queryUserPublishSupply(userid);
        return result;

    }

    //根据supplyid搜索supply
    //代码完毕 已测试 待调试
    @RequestMapping("/querySupplyById")
    @ResponseBody
    public Supply querySupplyById(@RequestBody String jsonstr){
        int supplyid=Integer.parseInt((String)JSON.parse(jsonstr));
        Supply result=supplyService.querySupplyById(supplyid);
        User owner = userService.queryGoodsOwner(supplyid);
        result.setContact(owner.getContact());
        result.setOwneravatar(owner.getAvatar());
        result.setOwnernickname(owner.getNickname());
        return result;
    }
    //删除某个supply
    //代码完毕 已测试 待调试
    @RequestMapping("/deleteSupply")
    @ResponseBody
    public void deleteSupply(@RequestBody String jsonstr){
        int supplyid=Integer.parseInt((String)JSON.parse(jsonstr));
        supplyService.deleteSupply(supplyid);
    }
    //增加一个supply
    //代码完毕 已测试 待调试
    @RequestMapping("/addSupply")
    @ResponseBody
    public void addSupply(@RequestBody String jsonstr){
        Supply supply = JSON.parseObject(jsonstr, new TypeReference<Supply>() {});
        System.out.print(supply);
        supplyService.addSupply(supply);
    }
    //更改一个supply
    //代码完毕 已测试 待调试
    @RequestMapping("/updateSupply")
    @ResponseBody
    public void updateSupply(@RequestBody String jsonstr){
        Supply supply = JSON.parseObject(jsonstr, new TypeReference<Supply>() {});
        System.out.print(supply);
        supplyService.updateSupply(supply);
    }


//    //点开查看详情的时候会调用的，查询这个goods的Details
//    //代码完毕 未测试 待调试
//    @RequestMapping("/querySupplyDetails")
//    @ResponseBody
//    public Supply querySupplyDetails(@RequestBody String jsonstr){
//        String supplyid=(String)JSON.parse(jsonstr);
//        SupplyDetails supplyDetails=supplyService.querySupplyDetails(supplyid);
//        Supply result=supplyService.querySupplyById(supplyid);
//        result.setSupplyDetails(supplyDetails);
//        return result;
//    }

    @RequestMapping("/updateCover")
    @ResponseBody
    public void updateCover(HttpServletRequest request, MultipartFile cover) throws IOException {
        //判断图片文件是否存在
        File dir = new File(coverPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        if (cover != null){
            String fileName = cover.getOriginalFilename();
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                String newfileName =  UUIDGenerrator.getUUID() + '.' + type;
                String path = coverPath + newfileName;
                //保存头像文件
                cover.transferTo(new File(path));
                int supplyUUID = Integer.parseInt(request.getParameter("supplyUUID"));
                Supply supply = supplyService.querySupplyById(supplyUUID);
                //更新数据库存储的路径
                supply.setCover("supplyImg\\"+path);
                supplyService.updateSupply(supply);
            }
        }
    }

}
