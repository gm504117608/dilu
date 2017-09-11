package com.dilu.common.cache.util;

import com.alibaba.fastjson.JSONObject;
import com.dilu.common.util.HttpClientApiService;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guonima
 * @create 2017-09-11 14:12
 */
@SpringBootTest
@RunWith(SpringRunner.class)public class HttpClientApiServiceTest {


    @Autowired
    private HttpClientApiService http;

    @Test
    public void doGet() throws Exception {
        String result = http.doGet("http://www.baidu.com");
        System.out.println("测试结果：" + result);
        Assert.assertTrue(result != null);
    }

    @Test
    public void doPost() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("selectedCategory", "all");
        String result1 = http.doPost("http://10.10.11.149:8080/secure/BrowseProjects.jspa", map);
        System.out.println("测试结果：" + result1);
        Assert.assertTrue(result1 != null);
    }

    @Test
    public void doPost1() throws Exception {
        String result = http.doPost("http://blog.csdn.net/liuchuanhong1/article/details/68194036");
        System.out.println("测试结果：" + result);
        Assert.assertTrue(result != null);
    }

    @Test
    public void doPost2() throws Exception {
        JSONObject json = new JSONObject();
        json.put("selectedCategory", "all");
        String result1 = http.doPost("http://10.10.11.149:8080/secure/BrowseProjects.jspa", json.toJSONString());
        System.out.println("测试结果：" + result1);
        Assert.assertTrue(result1 != null);
    }

}