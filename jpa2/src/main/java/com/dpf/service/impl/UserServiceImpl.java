package com.dpf.service.impl;


import com.dpf.bean.User;
import com.dpf.repository1.UserRepository1;
import com.dpf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dpf
 * @create 2019-12-27 15:24
 * @email 446933040@qq.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository1 userRepository1;

    @Override
    public List<User> getUserList() {
        return userRepository1.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository1.findById(id);
    }

    @Override
    public void save(User user) {
        User save = userRepository1.save(user);
    }

    @Override
    public void edit(User user) {
        User save = userRepository1.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository1.deleteById(id);
    }
}
