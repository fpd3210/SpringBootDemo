package com.dpf.redis_test.service;

import com.dpf.redis_test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author dpf
 * @create 2020-07-11 3:35 下午
 * @email 446933040
 */
@Service
@CacheConfig(cacheNames = "c1")
public class UserService {


    @Cacheable(key = "k")
    public User getUserById(Integer id,String name){
        return  new User();
    }

    @CachePut(key = "user.id")
    public User updateUserById(User user){
        return user;
    }

    @CacheEvict
    public void delUserById(Integer id){
        //删除操作
    }


}
