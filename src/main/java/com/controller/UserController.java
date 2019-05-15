package com.controller;


import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.entity.User;
import com.redis.Redis;
import com.service.UserService;
import com.util.SocketToPython;
import com.util.UUIDGenerrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Redis redis;

    //代码完毕 待调试
    @RequestMapping("/checkLogin")
    public @ResponseBody User checkLogin(@RequestBody String jsonstr) throws IOException {
        //socket通信调用python 然后返回一个json格式的user数据
          User user;
          //System.out.println(jsonstr);
          user = JSON.parseObject(jsonstr, new TypeReference<User>() {});
          String nickname=user.getNickname();
          String avatar=user.getAvatar();
          String userid=user.getUserid();
          String password=user.getPassword();
          String param="id="+userid+"&password="+password;
          JSONObject object= SocketToPython.sendGet(param);
          String state=object.getString("state");
        //登陆失败
        if(state=="false") {
            return null;
        }
        user=JSON.parseObject(object.get("data").toString(), new TypeReference<User>() {});
        user.setUserid(userid);
//        user.setAvatar(avatar);
//        user.setNickname(nickname);
        user.setAvatar("localhost/temp/100");
        user.setNickname("master");
        //说明此用户是第一次使用我们的系统
        if(userService.queryById(user.getUserid())==null){
            userService.addUser(user);
        }else {
            userService.updateUser(user);
        }
        //生成uuid 然后把uuid和username关联放到redis
        String curUUID= UUIDGenerrator.getUUID();
        System.out.println(curUUID);
        redis.set(curUUID,user.getUserid());
//        //然后把user的id设置为生成的那个uuid返回给前端
        user.setUserid(curUUID);
        return user;
    }

    //代码完毕 待调试
    @RequestMapping("/outLogin")
    public void outLogin(@RequestBody String jsonstr){
        String useruuid=(String)JSONObject.parse(jsonstr);
        redis.del(useruuid);
    }


    //测试用
    @RequestMapping("/queryUser")
    public @ResponseBody User testqueryUserByid(@RequestBody String userid){
        String useruuid=(String)JSON.parse(userid);
        User user=userService.queryById(useruuid);
        return user;
    }
    //测试用
    @RequestMapping("/updateUser")
    public void testupdateUser(@RequestBody String jsonstr){
        User user = JSON.parseObject(jsonstr, new TypeReference<User>() {});
        System.out.print(user);
        userService.updateUser(user);
    }
    //测试用
    @RequestMapping("/addUser")
    public @ResponseBody User testaddUser(@RequestBody String jsonstr){
        User user = JSON.parseObject(jsonstr, new TypeReference<User>() {});
        System.out.print(user);
        userService.addUser(user);
        return user;
    }


}
