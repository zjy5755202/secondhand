package com.controller;


import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.entity.User;
import com.redis.Redis;
import com.service.UserService;
import com.util.SocketToPython;
import com.util.SocketToPython1;
import com.util.UUIDGenerrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Redis redis;


    @RequestMapping("/checkLogin")
    public @ResponseBody User checkLogin(@RequestBody String jsonstr) throws IOException {

        //socket通信调用python 然后返回一个json格式的user数据
            User user=new User();
//          System.out.println(jsonstr);
//          User user = JSON.parseObject(jsonstr, new TypeReference<User>() {});
//          String username=user.getUserid();
//          String password=user.getPassword();
          JSONObject object= SocketToPython1.getLoginState(jsonstr);
          String state=object.getString("state");
        //登陆失败
        if(state=="false") {
            return user;
        }
        JSONObject userInfo=(JSONObject) object.get("user");
        user=JSON.toJavaObject(userInfo,User.class);
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


    @RequestMapping("/outLogin")
    public void outLogin(@RequestBody String useruuid){
        redis.del(useruuid);
    }


    @RequestMapping("/queryUser")
    public @ResponseBody User testqueryUserByid(@RequestBody String userid){
        String useruuid=(String)JSON.parse(userid);
        User user=userService.queryById(useruuid);
        return user;
    }

    @RequestMapping("/updateUser")
    public void testupdateUser(@RequestBody String jsonstr){
        User user = JSON.parseObject(jsonstr, new TypeReference<User>() {});
        System.out.print(user);
        userService.updateUser(user);
    }

    @RequestMapping("/addUser")
    public @ResponseBody User testaddUser(@RequestBody String jsonstr){
        User user = JSON.parseObject(jsonstr, new TypeReference<User>() {});
        System.out.print(user);
        userService.addUser(user);
        return user;
    }

//    @RequestMapping("/allUser")
//    public String list(Model model){
//        List<User> list = userService.queryAllUser();
//        model.addAttribute("list", list);
//        return "allUser";
//    }
//
//    @RequestMapping("/addUser")
//    public String addPaper(User user) {
//        userService.addUser(user);
//        return "redirect:/paper/allPaper";
//    }
//
//    @RequestMapping("/del/{userId}")
//    public String deleteUser(@PathVariable("userId") Long id) {
//        userService.deleteUserByUd(id);
//        return "redirect:/paper/allPaper";
//    }
//
//
//    @RequestMapping("/updatePaper")
//    public String updatePaper(Model model, User user) {
//        userService.updateUser(user);
//        user = userService.queryById(user.getUserid());
//        model.addAttribute("user", user);
//        return "redirect:/paper/allUser";
//    }



//    @RequestMapping("/checkLogin")
//    public String checkLogin(User user,Model model){
//      user=userService.checkLogin(user.getUserName(),user.getUserPassword());
//      if(user != null){
//            model.addAttribute("user",user);
//            return "success";
//        }
//      return "fail";
//    }


    //匹配的地址
    //ModelAndView
    //View是由setViewName决定的，决定让ViewResolver去哪找View文件
    //Model是由addObject来决定的，他的本质就是hashmap键值对
    //简单说就是View负责渲染Model,让你找到View对应的jsp,用这个jsp去渲染Model中的数据
    //@RequestMapping("/checkLogin")
    //@SessionAttributes("User")
//    public ModelAndView login(User user, HttpServletRequest request){
//        User tempuser=userService.queryByUsername(user.getUsername());
//        ModelAndView mv=new ModelAndView();
//        if(tempuser==null){
//            mv.setViewName("fail");
//            mv.addObject("errorMessage","用户不存在");
//        }else if(!tempuser.getUserpassword().equals(user.getUserpassword())){
//            mv.setViewName("fail");
//            mv.addObject("errorMessage","密码错误，请重新输入");
//        }else{
//            HttpSession session=request.getSession();
//            session.setAttribute("username",tempuser.getUsername());
//            session.setAttribute("loginname",tempuser.getLoginname());
//            session.setAttribute("img",tempuser.getImg());
//            mv.setViewName("success");
//            mv.addObject("User",tempuser);
//        }
//        return mv;
//    }



//    //注销用户
//    @RequestMapping("/outLogin")
//    public String outLogin(HttpSession session){
//        session.invalidate();
//        return "login";
//    }




}
