package com.dilu.common.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.*;

/**
 * Redis客户端访问
 */
@Component
public class RedisClient {

    @Autowired
    private JedisPool jedisPool; // 池化管理jedis链接池

    /**
     * 向缓存中设置字符串内容
     *
     * @param key   key
     * @param value value
     * @return 存储成功 true 否则 false
     * @throws Exception
     */
    public boolean set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置字符串内容 并带有有效期时间
     *
     * @param key     key
     * @param seconds 有效时间(单位 秒)
     * @param value   value
     * @return 存储成功 true 否则 false
     * @throws Exception
     */
    public boolean set(String key, int seconds, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key, seconds, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     *
     * @param key
     * @param value
     * @return 存储成功 true 否则 false
     * @throws Exception
     */
    public boolean set(String key, Object value) {
        Jedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = jedisPool.getResource();
            jedis.set(key, objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置字符串内容 并带有有效期时间
     *
     * @param key     key 存储key值
     * @param seconds 有效时间(单位 秒)
     * @param value   value 存储value值
     * @return 存储成功 true 否则 false
     * @throws Exception
     */
    public boolean set(String key, int seconds, Object value) {
        Jedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = jedisPool.getResource();
            jedis.setex(key, seconds, objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 删除缓存中得对象，根据key
     *
     * @param key
     * @return 存储成功 true 否则 false
     */
    public boolean del(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 根据key 获取内容
     *
     * @param key
     */
    public Object get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Object value = jedis.get(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }


    /**
     * 根据key 获取对象
     *
     * @param key
     */
    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            return JSON.parseObject(value, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 根据key 获取对象
     *
     * @param key
     */
    public <T> List<T> lGet(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            return JSON.parseArray(value, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     *
     * @param key
     * @param value
     * @return
     */
    public boolean hset(String key, String field, Object value) {
        Jedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = jedisPool.getResource();
            jedis.hset(key, field, objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     *
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field) {
        String result = "";
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.hget(key, field);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     *
     * @param key
     * @param field
     * @return
     */
    public List<String> hget(String key, String... field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hmget(key, field);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     *
     * @param key
     * @param value
     * @return
     */
    public boolean zset(String key, double score, Object value) {
        Jedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = jedisPool.getResource();
            jedis.zadd(key, score, objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }


    /**
     * 向缓存中设置对象list
     *
     * @param key
     * @param value
     * @return
     */
    public boolean lpush(String key, Object value) {
        Jedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = jedisPool.getResource();
            jedis.lpush(key, objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象hash
     *
     * @param key
     * @param map
     * @return
     */
    public boolean hmset(String key, Map map) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hmset(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象hash
     *
     * @param key
     * @param scoreMembers
     * @return
     */
    public boolean zadd(String key, Map<String, Double> scoreMembers) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.zadd(key, scoreMembers);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象hash
     *
     * @param key
     * @return
     */
    public List<String> hvals(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hvals(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象hash
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Object[] zrange(String key, Long start, Long end) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Set<String> zset = jedis.zrange(key, start, end);
            return zset.toArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }


    /**
     * 根据key 获取对象
     *
     * @param key
     * @return
     */
    public <T> T get(String key, String field, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.hget(key, field);
            return JSON.parseObject(value, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 根据key 获取对象
     *
     * @param key
     * @return
     */
    public <T> List<T> getList(String key, Class<T> clazz) {
        List<T> list = new ArrayList<T>();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            List<String> jsons = jedis.lrange(key, 0, -1);
            for (String json : jsons) {
                list.add(JSON.parseObject(json, clazz));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 设置某个key的过期时间
     * @param key 唯一值
     * @param seconds 有效时间
     * @return
     */
    public Long expire(String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

}
