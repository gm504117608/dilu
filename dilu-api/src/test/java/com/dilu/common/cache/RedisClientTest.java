package com.dilu.common.cache;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : guonima
 * @create : 2017-09-10-19:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisClientTest {

    @Autowired
    private RedisClient redisClient;

    @Test
    public void testRedis() throws Exception {
        redisClient.set("key", "123");
        System.out.println(redisClient.get("key"));
        Assert.assertEquals("获取值", redisClient.get("key"), "13");
    }
}