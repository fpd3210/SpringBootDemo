package com.dpf.mybatis.controller;

import com.dpf.mybatis.bean.User;
import com.dpf.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dpf
 * @create 2020-01-12 20:44
 * @email 446933040@qq.com
 */

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test1")
    public void test1() {
        List<User> allUser = userMapper.getAllUser();
        System.out.println(allUser);
        List<User> allUser2 = userMapper.getAllUser();
        System.out.println(allUser2);
    }
    @GetMapping("/test2")
    public void test2() {
        List<User> allUser = userMapper.getAllUser();
        System.out.println(allUser);
        List<User> allUser2 = userMapper.getAllUser();
        System.out.println(allUser2);
    }
}
