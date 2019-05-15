package com.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.GoodsDetails;
import com.entity.User;
import com.service.GoodsDetailsService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/GoodsDetails")
public class GoodsDetailsController {

    @Autowired
    private GoodsDetailsService goodsDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping("/addGoodsDetails")
    @ResponseBody
    public void addGoodsDetails(@RequestBody String jsonstr) throws IOException {
//        //保存数据库的路径
//        String sqlPath = null;
//        //定义文件保存的本地路径
//        String localPath="D:\\File\\";
//        //定义 文件名
//        String filename=null;
//        if(!goodDetails.getImgs().isEmpty()){
//            //生成uuid作为文件名称
//            String uuid = UUID.randomUUID().toString().replaceAll("-","");
//            //获得文件类型（可以判断如果不是图片，禁止上传）
//            String contentType=goodDetails.getImg().getContentType();
//            //获得文件后缀名
//            String suffixName=contentType.substring(contentType.indexOf("/")+1);
//            //得到 文件名
//            filename=uuid+"."+suffixName;
//            System.out.println(filename);
//            //文件保存路径
//            goodDetails.getImg().transferTo(new File(localPath+filename));
//        }
//        //把图片的相对路径保存至数据库
//        sqlPath = "/images/"+filename;
//        System.out.println(sqlPath);
//        goodDetails.setImgs(sqlPath);
//        goodDetailsDao.addGoodDetails(goodDetails);
//        return "Success";

        //测试用
        GoodsDetails goodsDetails = JSON.parseObject(jsonstr, new TypeReference<GoodsDetails>() {});
        goodsDetailsService.addGoodsDetails(goodsDetails);

    }



    //代码完毕 未测试 待调试
    @RequestMapping("/queryGoodsDetailsByid")
    @ResponseBody
    public GoodsDetails queryGoodsDetailsByid(@RequestBody String jsonstr) throws IOException {
        int goodsid=Integer.parseInt((String)JSON.parse(jsonstr));
        GoodsDetails result=goodsDetailsService.queryGoodsDetailsById(goodsid);
        User owner=userService.queryOwner(goodsid);
        result.setOwneravatar(owner.getAvatar());
        result.setOwnernickname(owner.getNickname());
        return result;
    }



    //代码完毕 未测试 待调试
    @RequestMapping("/deleteGoodsDetailsByid")
    @ResponseBody
    public void deleteGoodsDetailsByid(@RequestBody String jsonstr) throws IOException {
        int goodsid=Integer.parseInt((String)JSON.parse(jsonstr));
        goodsDetailsService.deleteGoodsDetailsById(goodsid);
    }



}
