package com.Test;

import com.controller.GoodsCollectionController;
import com.controller.SupplyCollectionController;
import com.entity.GoodsCollection;
import com.entity.SupplyCollection;
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
public class SupplyCollectionControllerTest {
    private MockMvc mockMvc;
    //需要测试的controller
    @Autowired
    private SupplyCollectionController supplyCollectionController;
    @Autowired
    private WebApplicationContext context;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(supplyCollectionController).build();
        System.out.println("movkMvc-Initial");
    }

    //已测试 成功通过
    @Test
    public void testStar() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        SupplyCollection supplyCollection=new SupplyCollection("2016302580189",10003);
        String json=mapper.writeValueAsString(supplyCollection);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/SupplyCollection/Star").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试  成功通过
    @Test
    public void testUnStar() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        SupplyCollection supplyCollection=new SupplyCollection("2016302580189",10003);
        String json=mapper.writeValueAsString(supplyCollection);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/SupplyCollection/UnStar").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }





}
