package com.Test;

import com.controller.SupplyController;
import com.controller.UserController;
import com.entity.Supply;
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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml",
        "classpath:spring/spring-mvc.xml","classpath:spring/spring-redis.xml","classpath:mybatis-config.xml"})

public class SupplyControllerTest {
    private MockMvc mockMvc;
    //需要测试的
    @Autowired
    private SupplyController supplyController;
    @Autowired
    private WebApplicationContext context;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(supplyController).build();
        System.out.println("movkMvc-Initial");
    }


    //已测试 成功通过
    @Test
    public void testaddSupply() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        Supply supply=new Supply();
        supply.setSupplyid(10003);
        supply.setUserid("2016302580190");
        supply.setCover(".....");
        supply.setTitle("190supply1");
        supply.setPrice(10.0);
        Timestamp time = new Timestamp(new Date().getTime());
        supply.setExpires(time);
        String json=mapper.writeValueAsString(supply);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/addSupply").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过
    @Test
    public void testquerySupplyById() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String supplyId="10000";
        String json=mapper.writeValueAsString(supplyId);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/querySupplyById").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }


    //已测试 成功通过
    @Test
    public void testdeleteSupply() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String supplyId="10003";
        String json=mapper.writeValueAsString(supplyId);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/deleteSupply").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }



    //已测试 成功通过
    @Test
    public void testupdateSupply() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        Supply supply=new Supply();
        supply.setSupplyid(10003);
        supply.setUserid("2016302580190");
        supply.setCover(".");
        supply.setTitle("190supply1");
        supply.setPrice(20.0);
        Timestamp time = new Timestamp(new Date().getTime());
        supply.setExpires(time);
        String json=mapper.writeValueAsString(supply);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/updateSupply").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过
    @Test
    public void testquerySupplyByTime() throws Exception {
        System.out.println("before----------------post");
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/querySupplyByTime").contentType("application/json;charset=UTF-8").accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过
    @Test
    public void testquerySupplyByTitle() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String title="supply1";
        String json=mapper.writeValueAsString(title);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/querySupplyByTitle").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过
    @Test
    public void testqueryUserCollectionSupply() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String userid="2016302580189";
        String json=mapper.writeValueAsString(userid);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/queryUserCollectionSupply").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过
    @Test
    public void testqueryUserPublishSupply() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String userid="2016302580188";
        String json=mapper.writeValueAsString(userid);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/queryUserPublishSupply").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //未测试
    @Test
    public void testquerySupplyDetails() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String supplyid="10000";
        String json=mapper.writeValueAsString(supplyid);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/queryUserPublishSupply").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }




}
