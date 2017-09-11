package com.dilu.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author : guonima
 * @create : 2017-09-10-19:29
 */
@Configuration
@PropertySource(value = "classpath:config/redis.properties", encoding = "utf-8")
public class RedisConfig {

    // Redis数据库索引（默认为0）
    @Value("${redis.database}")
    public int database;

    // Redis服务器地址
    @Value("${redis.host}")
    public String host;

    // Redis服务器连接端口
    @Value("${redis.port}")
    public int port;

    // Redis服务器连接密码（默认为空）
    @Value("${redis.password}")
    public String password;

    // 连接池最大连接数（使用负值表示没有限制）
    @Value("${redis.pool.max-active}")
    public int poolMaxActive;

    // 连接池最大阻塞等待时间（使用负值表示没有限制）
    @Value("${redis.pool.max-wait}")
    public int poolMaxWait;

    // 连接池中的最大空闲连接
    @Value("${redis.pool.max-idle}")
    public int poolMaxIdle;

    // 连接池中的最小空闲连接
    @Value("${redis.pool.min-idle}")
    public int poolMinIdle;

    // 连接超时时间（毫秒）
    @Value("${redis.timeout}")
    public int timeout;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(poolMaxIdle);
        config.setMinIdle(poolMinIdle);
        config.setMaxWaitMillis(poolMaxWait);
        config.setMaxTotal(poolMaxActive);
        return new JedisPool(config, host, port, timeout, password, database);
    }

}
