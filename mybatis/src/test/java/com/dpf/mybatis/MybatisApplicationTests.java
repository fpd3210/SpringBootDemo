package com.dpf.mybatis;

import com.dpf.mybatis.bean.User;
import com.dpf.mybatis.controller.UserController;
import com.dpf.mybatis.mapper.UserMapper;
import com.dpf.mybatis.mapper.UserMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapper2 userMapper2;

    @Test
    void test1(){
        List<User> allUser = userMapper.getAllUser();
        allUser.forEach(user->{
            System.out.println(user);
        });

        List<User> allUser1 = userMapper2.getAllUser();

        allUser1.forEach(user->{
            System.out.println(user);
        });
    }

}
