//package com.util;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.ShardedJedis;
//import redis.clients.jedis.ShardedJedisPool;
//
//public class RedisClient {
//    private Jedis jedis;
//    private JedisPool jedisPool;
//    private ShardedJedis shardedJedis;
//    private ShardedJedisPool shardedJedisPool;
//
//    public RedisClient()
//    {
//        initialPool();
//        initialShardedPool();
//        shardedJedis = shardedJedisPool.getResource();
//        jedis = jedisPool.getResource();
//    }
//
//    /**
//     * 初始化非切片池
//     */
//    private void initialPool()
//    {
//        // 池基本配置
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxActive(20);
//        config.setMaxIdle(5);
//        config.setMaxWait(1000l);
//        config.setTestOnBorrow(false);
//
//        jedisPool = new JedisPool(config,"127.0.0.1",6379);
//    }
//
//    /**
//     * 初始化切片池
//     */
//    private void initialShardedPool()
//    {
//        // 池基本配置
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxActive(20);
//        config.setMaxIdle(5);
//        config.setMaxWait(1000l);
//        config.setTestOnBorrow(false);
//        // slave链接
//        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
//        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));
//
//        // 构造池
//        shardedJedisPool = new ShardedJedisPool(config, shards);
//    }
//
//    public void show() {
//        KeyOperate();
//        StringOperate();
//        ListOperate();
//        SetOperate();
//        SortedSetOperate();
//        HashOperate();
//        jedisPool.returnResource(jedis);
//        shardedJedisPool.returnResource(shardedJedis);
//    }
//
//    private void KeyOperate() {
//    }
//
//    private void StringOperate() {
//    }
//
//    private void ListOperate() {
//    }
//
//    private void SetOperate() {
//    }
//
//    private void SortedSetOperate() {
//    }
//
//    private void HashOperate() {
//    }
//
//}
