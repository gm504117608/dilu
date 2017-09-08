package com.dilu.controller.member;

import com.alibaba.fastjson.JSON;
import com.dilu.domain.member.MemberDO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guonima
 * @create 2017-09-08 9:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional// 增加事务控制
@EnableTransactionManagement(proxyTargetClass = true) // 设置执行完成之后事务都回滚
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findMembers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/members/3"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/members/5"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void save() throws Exception {
        MemberDO memberDO = new MemberDO();
        memberDO.setAvatarUrl("http://www.baidu.com");
        memberDO.setCity("beijing");
        memberDO.setCountry("china");
        memberDO.setEmail("123467@12.123");
        memberDO.setEnabled(1);
        memberDO.setGender(1);
        memberDO.setMobile("13552420016");
        memberDO.setProvince("zhejiang");
        memberDO.setNickName("guonima");
        memberDO.setOpenid("11111111111111111111");
        memberDO.setUnionid("222222222222");
        memberDO.setSignature("laizheihsinkfgh sdfsd ");

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/members")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JSON.toJSONString(memberDO))).andReturn();

        System.out.println("==============" + result.getResponse().getStatus());
    }

    @Test
    public void update() throws Exception {
        MemberDO memberDO = new MemberDO();
        memberDO.setId(7L);
        memberDO.setAvatarUrl("http://www.github.com");
        memberDO.setCity("beijing");
        memberDO.setCountry("china");
        memberDO.setEmail("123467@12.123");
        memberDO.setEnabled(1);
        memberDO.setGender(1);
        memberDO.setMobile("13552420016");
        memberDO.setProvince("zhejiang");
        memberDO.setNickName("guonima");
        memberDO.setOpenid("11111111111111111111");
        memberDO.setUnionid("222222222222");
        memberDO.setSignature("laizheihsinkfgh sdfsd ");

        MvcResult result = mvc.perform(MockMvcRequestBuilders.put("/members")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JSON.toJSONString(memberDO))).andReturn();

        Assert.assertFalse(result.getResponse().getContentAsString().equals("0"));

        System.out.println("==============" + result.getResponse().getStatus());
    }

}