package com.dpf.cache.service;

import com.dpf.cache.domain.User;
import com.dpf.cache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pikachues
 * Created 2022/5/17
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;


    @Cacheable(cacheNames = "userList")
    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
