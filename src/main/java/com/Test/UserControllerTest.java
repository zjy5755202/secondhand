package com.Test;

import com.controller.UserController;
import com.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml",
        "classpath:spring/spring-mvc.xml","classpath:spring/spring-redis.xml","classpath:mybatis-config.xml"})
public class UserControllerTest {
    private MockMvc mockMvc;
    //需要测试的
    @Autowired
    private UserController userController;
    @Autowired
    private WebApplicationContext context;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        System.out.println("movkMvc-Initial");
    }

    //已测试 成功通过
    @Test
    public void testaddUser() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        User user=new User();
        user.setUserid("2016302580190");
        user.setAvatar("....");
        user.setNickname("test3");
        user.setName("杨浩麟");
        user.setGender('男');
        user.setGrade(2016);
        user.setSchool("计算机学院");
        user.setMajor("软件工程");
        user.setPassword("123456");
        String json=mapper.writeValueAsString(user);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/user/addUser").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过
    @Test
    public void testupdateUser() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        User user=new User();
        user.setUserid("2016302580188");
        user.setAvatar("....");
        user.setNickname("hh");
        user.setName("朱江源");
        user.setGender('男');
        user.setGrade(2016);
        user.setSchool("计算机学院");
        user.setMajor("软件工程");
        user.setPassword("123456");
        String json=mapper.writeValueAsString(user);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/user/updateUser").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }


    //已测试 成功通过
    @Test
    public void testqueryUserById() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String userid="2016302580188";
        String json=mapper.writeValueAsString(userid);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/user/queryUser").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");

    }



}
