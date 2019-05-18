package com.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.entity.Goods;
import com.entity.User;
import com.redis.Redis;
import com.service.GoodsService;
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
@RequestMapping("/Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;

    @Autowired
    private Redis redis;

    private String coverPath ="D:\\softwarePro\\target\\secondhand\\goodsImg\\";



    //首页加载的时候按照时间来挑选一定的goods
    @RequestMapping("/queryGoodsByTime")
    @ResponseBody
    public List<Goods> queryGoodsByTime(){
        List<Goods> result=goodsService.queryGoodsByTime();
        return result;
    }

    //根据标题搜索Goods
    //代码完毕 已测试 待调试
    @RequestMapping("/queryGoodsByName")
    @ResponseBody
    public List<Goods> queryGoodsByName(@RequestBody String jsonstr){
        String name=(String)JSON.parse(jsonstr);
        List<Goods> result=goodsService.queryGoodsByName(name);
        return result;
    }

    //查看某个用户收藏的Goods
    //代码完毕 未测试 待调试
    @RequestMapping("/queryUserCollectionGoods")
    @ResponseBody
    public List<Goods> queryUserCollectionGoods(@RequestBody String jsonstr){
//        String tempuserid=(String)JSON.parse(jsonstr);
//        String userid=redis.get(tempuserid);
//        List<Goods> result=goodsService.queryUserCollectionGoods(userid);
//        return result;
        //测试使用
        String userid=(String)JSON.parse(jsonstr);
        List<Goods> result=goodsService.queryUserCollectionGoods(userid);
        return result;
    }

    //查看某个用户发布的Goods
    //代码完毕 未测试 待调试
    @RequestMapping("/queryUserPublishGoods")
    @ResponseBody
    public List<Goods> queryUserPublishGoods(@RequestBody String jsonstr){
//        String tempuserid=(String)JSON.parse(jsonstr);
//        String userid=redis.get(tempuserid);
//        List<Goods> result=goodsService.queryUserPublishGoods(userid);
//        return result;
        //测试使用
        String userid=(String)JSON.parse(jsonstr);
        List<Goods> result=goodsService.queryUserPublishGoods(userid);
        return result;

    }

    //根据goodid来搜索Good
    //代码完毕 已测试 待调试
    @RequestMapping("/queryGoodsById")
    @ResponseBody
    public Goods queryGoodsById(@RequestBody String jsonstr){
        int goodsid=Integer.parseInt((String)JSON.parse(jsonstr));
        Goods result=goodsService.queryGoodsById(goodsid);
        User owner = userService.queryGoodsOwner(goodsid);
        result.setContact(owner.getContact());
        result.setOwneravatar(owner.getAvatar());
        result.setOwnernickname(owner.getNickname());
        return result;
    }

    //删除一个Good
    //代码完毕 已测试 待调试
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public void deleteGoods(@RequestBody String jsonstr){
        int goodsid=Integer.parseInt((String)JSON.parse(jsonstr));
        goodsService.deleteGoods(goodsid);
    }

    //上传一个Good
    //代码完毕 已测试 待调试
    @RequestMapping("/addGoods")
    @ResponseBody
    public int addGoods(@RequestBody String jsonstr){
        Goods goods = JSON.parseObject(jsonstr, new TypeReference<Goods>() {});
        goodsService.addGoods(goods);
        return goods.getGoodsid();
    }

    //更新一个Good
    //代码完毕 已测试 待调试
    @RequestMapping("/updateGoods")
    @ResponseBody
    public void updateGoods(@RequestBody String jsonstr){
        Goods goods = JSON.parseObject(jsonstr, new TypeReference<Goods>() {});
        goodsService.updateGoods(goods);
    }

//    //点开查看详情的时候会调用的，查询这个goods的Details
//    //代码完毕 未测试 待调试
//    @RequestMapping("/queryGoodsDetails")
//    @ResponseBody
//    public Goods queryGoodsDetails(@RequestBody String jsonstr){
//        String goodsid=(String)JSON.parse(jsonstr);
//        GoodsDetails goodsDetails=goodsService.queryGoodsDetailsById(goodsid);
//        Goods result=goodsService.queryGoodsById(goodsid);
//        result.setGoodsDetails(goodsDetails);
//        return result;
//    }


    /**商品封面改变
     * @param request
     * @param cover 封面图片文件
     * @throws IOException
     */
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
                int goodUUID = Integer.parseInt(request.getParameter("goodUUID"));
                Goods good = goodsService.queryGoodsById(goodUUID);
                //更新数据库存储的路径
                good.setCover("goodsImg/"+newfileName);
                goodsService.updateGoods(good);
            }
        }
    }



}
