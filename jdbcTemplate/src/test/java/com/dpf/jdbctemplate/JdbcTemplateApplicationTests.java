package com.dpf.jdbctemplate;

import com.dpf.jdbctemplate.pojo.User;
import com.dpf.jdbctemplate.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcTemplateApplicationTests {

    @Autowired
    private HelloService helloService;

    @Test
    void testAdd() {
        User user = new User();
        user.setId(1);
        user.setName("tom");
        helloService.add(user);
    }

    @Test
    void testSelect(){
        System.out.println(helloService.select(1));
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1);
        user.setName("tom1");
        helloService.update(user);
        System.out.println(helloService.select(1));
    }

    @Test
    void delete(){
        helloService.delete(1);
    }

}
