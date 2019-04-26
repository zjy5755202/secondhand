package com.Test;

import com.controller.GoodsController;
import com.entity.Goods;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml",
        "classpath:spring/spring-mvc.xml","classpath:spring/spring-redis.xml","classpath:mybatis-config.xml"})
public class GoodsControllerTest {
    private MockMvc mockMvc;
    //需要测试的controller
    @Autowired
    private GoodsController goodController;
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
    public void testqueryGoodsById() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String goodsid="10000";
        String json=mapper.writeValueAsString(goodsid);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Goods/queryGoodsById").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }
    @Test
    public void testdeleteGoods() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        String goodsid="10000";
        String json=mapper.writeValueAsString(goodsid);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Goods/deleteGoods").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }
    @Test
    public void testaddGoods() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        Goods goods=new Goods();
        goods.setGoodsid("10000");
        goods.setUserid("2016302580188");
        goods.setCover(".....");
        goods.setName("goods1");
        goods.setPrice(100);
        String json=mapper.writeValueAsString(goods);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Goods/addGoods").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");

    }
    @Test
    public void testupdateGoods() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        Goods goods=new Goods();
        goods.setGoodsid("10000");
        goods.setUserid("2016302580188");
        goods.setCover(".....");
        goods.setName("goods1update");
        goods.setPrice(100);
        String json=mapper.writeValueAsString(goods);
        System.out.println("before--------------------post");
        System.out.println(json.toString());
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/Goods/updateGoods").contentType("application/json;charset=UTF-8").content(json).accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = action.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("after---------------------post");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }
    @Test
    public void testqueryGoodDetails() throws Exception {

    }





}
