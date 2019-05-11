package com.Test;

import com.controller.GoodsDetailsController;
import com.controller.UserController;
import com.entity.GoodsDetails;
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

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml",
        "classpath:spring/spring-mvc.xml","classpath:spring/spring-redis.xml","classpath:mybatis-config.xml"})

public class GoodsDetailsControllerTest {
    private MockMvc mockMvc;
    //需要测试的
    @Autowired
    private GoodsDetailsController goodsDetailsController;
    @Autowired
    private WebApplicationContext context;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(goodsDetailsController).build();
        System.out.println("movkMvc-Initial");
    }

    //已测试
    @Test
    public void testaddGoodsDetails() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        GoodsDetails goodsDetails=new GoodsDetails();
        goodsDetails.setGoodsid(10001);
        goodsDetails.setImages("....");
        goodsDetails.setDescription("description1");
        goodsDetails.setCollections(0);
        goodsDetails.setContact("1181370590");
        String json=mapper.writeValueAsString(goodsDetails);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/GoodsDetails/addGoodsDetails").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //未测试
    @Test
    public void testupdateGoodsDetails() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        GoodsDetails goodsDetails=new GoodsDetails();
        goodsDetails.setGoodsid(10000);
        goodsDetails.setImages("...");
        goodsDetails.setDescription("descriptionchange");
        goodsDetails.setCollections(0);
        goodsDetails.setContact("1181370590");
        String json=mapper.writeValueAsString(goodsDetails);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/GoodsDetails/updateGoodsDetails").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试  成功通过
    @Test
    public void testdeleteGoodsDetailsById() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String goodsid="10001";
        String json=mapper.writeValueAsString(goodsid);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/GoodsDetails/deleteGoodsDetailsByid").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过
    @Test
    public void testqueryGoodsDetailsById() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String goodsid="10000";
        String json=mapper.writeValueAsString(goodsid);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/GoodsDetails/queryGoodsDetailsByid").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }



}
