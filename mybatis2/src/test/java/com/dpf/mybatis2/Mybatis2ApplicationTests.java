package com.dpf.mybatis2;

import com.dpf.mybatis2.bean.User;
import com.dpf.mybatis2.mapper1.UserMapper1;
import com.dpf.mybatis2.mapper2.UserMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;


@SpringBootTest
class Mybatis2ApplicationTests {

    @Autowired
    private UserMapper1 userMapper1;

    @Autowired
    private UserMapper2 userMapper2;

    @Test
    void test() {
        List<User> allUsers = userMapper1.getAllUsers();
        allUsers.forEach(user -> {
            System.out.println(user);
        });

        List<User> allUsers1 = userMapper2.getAllUsers();
        allUsers1.forEach(user -> {
            System.out.println(user);
        });
    }

}
