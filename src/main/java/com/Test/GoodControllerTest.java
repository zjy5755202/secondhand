package com.Test;

import com.controller.GoodController;
import com.entity.Good;
import com.entity.GoodDetails;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml",
        "classpath:spring/spring-mvc.xml","classpath:spring/spring-redis.xml","classpath:mybatis-config.xml"})
public class GoodControllerTest {
    private MockMvc mockMvc;
    //需要测试的controller
    @Autowired
    private GoodController goodController;
    @Autowired
    private WebApplicationContext context;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(goodController).build();
        System.out.println("movkMvc-Initial");
    }

    @Test
    public void testqueryGoodByTitle() throws Exception {
//        ObjectMapper mapper=new ObjectMapper();
//        Good good=new Good();
//        String json=mapper.writeValueAsString(good);
//        System.out.println("before--------------------post");
//        System.out.println(json.toString());
//        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/user/checkLogin").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
//        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//        System.out.println("after---------------------post");
//        String result = mvcResult.getResponse().getContentAsString();
//        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    @Test
    public void testqueryUserCollectionGood() throws Exception {

    }
    @Test
    public void testqueryUserPublishGoods() throws Exception {

    }
    @Test
    public void testqueryGoodById() throws Exception {

    }
    @Test
    public void testdeleteGood() throws Exception {

    }
    @Test
    public void testaddGood() throws Exception {

    }
    @Test
    public void testupdateGood() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        Good good=new Good();
        GoodDetails goodDetails=new GoodDetails();
        goodDetails.setImgs(".........");
        goodDetails.setCollections(100);
        goodDetails.setContent("content");
        goodDetails.setGoodid("100000");
        good.setUserid("zhzhuzhu");
        good.setName("test");
        good.setGoodDetails(goodDetails);
        String json=mapper.writeValueAsString(good);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Good/updateGood").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }
    @Test
    public void testqueryGoodDetails() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        Good good=new Good();
        GoodDetails goodDetails=new GoodDetails();
        goodDetails.setImgs(".........");
        goodDetails.setCollections(100);
        goodDetails.setContent("content");
        goodDetails.setGoodid("100000");
        good.setUserid("zhzhuzhu");
        good.setName("test");
        good.setGoodDetails(goodDetails);
        String json=mapper.writeValueAsString(good);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Good/queryGoodDetails").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }





}
