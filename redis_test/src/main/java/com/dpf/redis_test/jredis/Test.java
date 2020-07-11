package com.dpf.redis_test.jredis;

import redis.clients.jedis.Jedis;

/**
 * @author dpf
 * @create 2020-07-11 3:58 下午
 * @email 446933040
 */
public class Test {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        String ping = jedis.ping();
        System.out.println(ping);
    }
}
