package com.dpf.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Pikachues
 * Created 2022/5/23
 */
@Component
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存储token
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public boolean setEx(String key,String value,long expire){
        boolean result = false;
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key,value);
            redisTemplate.expire(key,expire, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 是否存在对应key
     * @param key
     * @return
     */
    public boolean exists(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 根据key删除
     * @param key
     * @return
     */
    public boolean remove(String key){
        if(redisTemplate.hasKey(key)){
            return redisTemplate.delete(key);
        }
        return false;
    }
}
