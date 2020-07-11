package com.dpf.redis_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpf
 * @create 2020-07-11 2:37 下午
 * @email 446933040
 */
@RestController
public class HelloController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping(value = "/hello")
    public void hello1(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("k1","v1");
        System.out.println(valueOperations.get("k1"));
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "/hello2")
    public void hello2(){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("k2","v2");
        System.out.println(stringStringValueOperations.get("k2"));
    }
}
