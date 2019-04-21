package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class Redis {
    //jedis连接池文件
    private JedisPool jedispool;
    public JedisPool getJedispool() {
        return jedispool;
    }
    public void setJedispool(JedisPool jedispool) {
        this.jedispool = jedispool;
    }
    public String set(String key, String value) {
        // TODO Auto-generated method stub
        //从连接池中获得一个连接
        Jedis jedis=jedispool.getResource();
        //直接操作redis
        String result = jedis.set(key, value);
        //关闭该连接 jedis.close();
        return result;
    }

    public String get(String key) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    public Boolean exists(String key) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        Boolean result = jedis.exists(key);
        jedis.close(); return result;
    }

    public Long expire(String key, int seconds) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        Long result = jedis.expire(key, seconds);
        jedis.close(); return result;
    }

    public Long ttl(String key) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        Long result = jedis.ttl(key);
        return result;
    }
    public Long incr(String key) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    public String hget(String key, String field) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        String result = jedis.hget(key, field);
        jedis.close();
        return result;
    }

    public Long hdel(String key, String... field) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        Long result = jedis.hdel(key, field);
        jedis.close();
        return result;
    }

    public Boolean hexistes(String key, String field) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        Boolean result = jedis.hexists(key, field);
        jedis.close();
        return result;
    }

    public List<String> hvals(String key) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        List<String> result = jedis.hvals(key);
        jedis.close();
        return result;
    }

    public Long del(String key) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        Long result = jedis.del(key); jedis.close(); return result; }

    public Long hset(String key, String field, String value) {
        // TODO Auto-generated method stub
        Jedis jedis=jedispool.getResource();
        Long result = jedis.hset(key, field, value);
        jedis.close();
        return result;
    }



}
