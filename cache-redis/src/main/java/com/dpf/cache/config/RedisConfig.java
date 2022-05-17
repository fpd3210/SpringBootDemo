package com.dpf.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Pikachues
 * Created 2022/5/17
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

        /*
            RedisTemplate 中，key 默认的序列化方案是 JdkSerializationRedisSerializer 。
            而在 StringRedisTemplate 中，key 默认的序列化方案是 StringRedisSerializer ，
            因此，如果使用 StringRedisTemplate ，默认情况下 key 前面不会有前缀。
            使用JdkSerializationRedisSerializer时会有获取不到值得情况，所以key统一使用StringRedisSerializer序列化
         */
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        //非spring注入使用RedisTemplate,需先调用afterPropertiesSet()方法
        template.afterPropertiesSet();
        return template;
    }

}