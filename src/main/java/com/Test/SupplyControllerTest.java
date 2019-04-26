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

    @Test
    public void testdeleteSupply() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String supplyId="10000";
        String json=mapper.writeValueAsString(supplyId);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/deleteSupply").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    @Test
    public void testaddSupply() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        Supply supply=new Supply();
        supply.setSupplyid("10000");
        supply.setUserid("2016302580188");
        supply.setCover("000000");
        supply.setTitle("00000");
        supply.setPrice(10.0);
        String strDate="2005年04月22日";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        Date date = simpleDateFormat.parse(strDate);
        supply.setExpires(date);
        String json=mapper.writeValueAsString(supply);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/addSupply").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }

    @Test
    public void testupdateSupply() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        Supply supply=new Supply();
        supply.setSupplyid("10000");
        supply.setUserid("2016302580188");
        supply.setCover("11111111");
        supply.setTitle("00000");
        supply.setPrice(20.0);
        String strDate="2005年04月22日";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        Date date = simpleDateFormat.parse(strDate);
        supply.setExpires(date);
        String json=mapper.writeValueAsString(supply);
        System.out.println("before----------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Supply/updateSupply").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }
}
