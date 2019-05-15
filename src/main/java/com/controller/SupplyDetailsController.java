package com.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.GoodsDetails;
import com.entity.SupplyDetails;
import com.entity.User;
import com.service.SupplyDetailsService;
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
@RequestMapping("/SupplyDetails")
public class SupplyDetailsController {

    @Autowired
    private SupplyDetailsService supplyDetailsService;

    @Autowired
    private UserService userService;

    private String supplyDetailImgPath = "./img/SupplyDetail";
    //分隔img里可能的多个图片
    private String imgSpliter = "&";

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
        User owner=userService.querySupplyOwner(supplyid);
        result.setOwneravatar(owner.getAvatar());
        result.setOwnernickname(owner.getNickname());
        return result;
    }

    //代码完毕 未测试 待调试
    @RequestMapping("/deleteSupplyDetailsById")
    @ResponseBody
    public void deleteSupplyDetailsByid(@RequestBody String jsonstr) throws IOException {
        int supplyid=Integer.parseInt((String)JSON.parse(jsonstr));
        supplyDetailsService.deleteSupplyDetailsById(supplyid);
    }

    /**上传供需详情图片
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
                String path = supplyDetailImgPath + '/' + UUIDGenerrator.getUUID() + '.' + type;
                //保存图片文件
                img.transferTo(new File(path));
                //获取UUID
                int goodUUID = Integer.parseInt(request.getParameter("goodUUID"));

                SupplyDetails supplyDetails = supplyDetailsService.querySupplyDetailsById(goodUUID);
                String oldImg = supplyDetails.getImages();
                if (oldImg.length() > 0) {
                    //已有图片
                    supplyDetails.setImages(oldImg + imgSpliter + path);
                }
                else
                    supplyDetails.setImages(path);

                //更新数据库存储的路径
                supplyDetailsService.updateSupplyDetails(supplyDetails);
            }
        }
    }
}
