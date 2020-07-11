package com.dpf.redis_test.jredis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author dpf
 * @create 2020-07-11 4:00 下午
 * @email 446933040
 */
public class Test2 {
    public static void main(String[] args) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(20);
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("k3","v3");
        System.out.println(jedis.ping());
        System.out.println(jedis.get("k3"));
    }
}
