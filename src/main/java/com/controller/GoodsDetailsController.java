package com.controller;


import com.entity.GoodsDetails;
import com.service.GoodsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/GoodsDetails")
public class GoodsDetailsController {

    @Autowired
    private GoodsDetailsService goodsDetailsService;

    @RequestMapping("/addGoodsDetails")
    public String addGoodsDetails(GoodsDetails goodDetails) throws IOException {
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
            return null;
    }


    @RequestMapping("/queryGoodDetailsByid")
    public GoodsDetails queryGoodsDetailsByid(String goodid) throws IOException {
        goodsDetailsService.queryGoodsDetailsById(goodid);
        return null;
    }

    @RequestMapping("/deleteGoodsDetailsByid")
    public void deleteGoodsDetailsByid(String goodid) throws IOException {
        goodsDetailsService.deleteGoodsDetailsById(goodid);
    }



}
