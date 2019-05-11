package com.Test;

import com.controller.SupplyDetailsController;
import com.controller.UserController;
import com.entity.SupplyDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.SupplyDetailsService;
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

public class SupplyDetailControllerTest {
    private MockMvc mockMvc;
    //需要测试的
    @Autowired
    private SupplyDetailsController supplyDetailsController;
    @Autowired
    private WebApplicationContext context;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(supplyDetailsController).build();
        System.out.println("movkMvc-Initial");
    }


    //已测试 成功通过
    @Test
    public void testaddSupplyDetails() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        SupplyDetails supplyDetails=new SupplyDetails();
        supplyDetails.setSupplyid(10002);
        supplyDetails.setImages("....");
        supplyDetails.setDescription("description");
        supplyDetails.setCollections(0);
        supplyDetails.setContact("1090109748");
        String json=mapper.writeValueAsString(supplyDetails);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/SupplyDetails/addSupplyDetails").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过
    @Test
    public void testupdateGoodsDetails() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        SupplyDetails supplyDetails=new SupplyDetails();
        supplyDetails.setSupplyid(10000);
        supplyDetails.setImages("....");
        supplyDetails.setDescription("descriptionChange");
        supplyDetails.setCollections(0);
        supplyDetails.setContact("1181370590");
        String json=mapper.writeValueAsString(supplyDetails);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/SupplyDetails/updateSupplyDetails").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过测试
    @Test
    public void testdeleteGoodsDetailsById() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String supplyid="10002";
        String json=mapper.writeValueAsString(supplyid);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/SupplyDetails/deleteSupplyDetailsById").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    //已测试 成功通过
    @Test
    public void testqueryGoodsDetailsById() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String supplyid="10000";
        String json=mapper.writeValueAsString(supplyid);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/SupplyDetails/querySupplyDetailsById").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }




}
