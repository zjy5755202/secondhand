package com.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.GoodsDetails;
import com.entity.User;
import com.service.GoodsDetailsService;
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

@Controller
@RequestMapping("/GoodsDetails")
public class GoodsDetailsController {

    @Autowired
    private GoodsDetailsService goodsDetailsService;

    @Autowired
    private UserService userService;
    private String goodsDetailImgPath = "./img/GoodDetail";
    //分隔img里可能的多个图片
    private String imgSpliter = "&";

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

    /**添加图片
     * @param request
     * @param response
     * @param img 上传的图片
     * @throws IOException
     */
    @RequestMapping("/addImg")
    public void addImg(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "img", required = false) MultipartFile img) throws IOException
    {
        //判断图片文件是否存在
        if (img != null){
            String fileName = img.getOriginalFilename();
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                String path = goodsDetailImgPath + '/' + UUIDGenerrator.getUUID() + '.' + type;
                //保存图片文件
                img.transferTo(new File(path));
                //获取UUID
                int goodUUID = Integer.parseInt(request.getParameter("goodUUID"));

                GoodsDetails goodsDetails = goodsDetailsService.queryGoodsDetailsById(goodUUID);
                String oldImg = goodsDetails.getImages();
                if (oldImg.length() > 0) {
                    //已有图片
                    goodsDetails.setImages(oldImg + imgSpliter + path);
                }
                else
                    goodsDetails.setImages(path);

                //更新数据库存储的路径
                goodsDetailsService.updateGoodsDetails(goodsDetails);
            }
        }
    }

}
