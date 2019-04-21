package com.controller;


import com.dao.GoodDetailsDao;
import com.entity.GoodDetails;
import com.service.GoodDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/GoodDetails")
public class GoodDetailsController {

    @Autowired
    private GoodDetailsService goodDetailsService;

    @RequestMapping("/upload")
    public String upload(GoodDetails goodDetails) throws IOException {
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
    public GoodDetails queryGoodDetailsByid(String goodid) throws IOException {
        goodDetailsService.queryGoodDetailsById(goodid);
        return null;
    }

    @RequestMapping("/delGoodDetailsByid")
    public void delGoodDetailsByid(String goodid) throws IOException {
        goodDetailsService.deleteGoodDetailsById(goodid);
    }



}
