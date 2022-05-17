package com.dpf.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class CacheRedisApplicationTests {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("k1","v1");
        System.out.println(redisTemplate.opsForValue().get("v1"));
    }

}
