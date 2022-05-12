package com.dpf.mongo;

import com.dpf.mongo.model.User;
import com.dpf.mongo.mongo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.List;

/**
 * @author Pikachues
 * Created 2022/5/1
 */
@SpringBootTest
public class MongoRepository {
    @Autowired
    private UserRepository repository;

    @Test
    public void add(){
        User user = new User();
        user.setAge(18);
        user.setName("w1");
        user.setEmail("1111@qq.com");
        User save = repository.save(user);
    }

    /**
     * 条件查询
     */
    @Test
    public void findByCondition(){
        User user = new User();
        user.setAge(18);
        user.setName("ww");
        Example<User> userExample = Example.of(user);
        List<User> all = repository.findAll(userExample);
        for (User u : all) {
            System.out.println(u);
        }

    }

    /**
     * 模糊查询
     */
    @Test
    public void findByConditionLike(){
        //创建匹配器，即如何使用查询条件
        ExampleMatcher stringMatcher = ExampleMatcher.matching()
                //改变默认字符串匹配方式：模糊查询
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                //改变默认大小写忽略方式：忽略大小写
                .withIgnoreCase(true);

        User user = new User();
        user.setName("w");
        Example<User> userExample = Example.of(user,stringMatcher);
        List<User> all = repository.findAll(userExample);
        for (User u : all) {
            System.out.println(u);
        }

    }

    @Test
    public void findByPage(){
        Sort sort = Sort.by(Sort.Direction.DESC, "age");
        Pageable pageable = PageRequest.of(0, 10, sort);

        ExampleMatcher stringMatcher = ExampleMatcher.matching()
                //改变默认字符串匹配方式：模糊查询
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                //改变默认大小写忽略方式：忽略大小写
                .withIgnoreCase(true);

        User user = new User();
        user.setName("w");

        Example<User> userExample = Example.of(user, stringMatcher);
        Page<User> userPage = repository.findAll(userExample, pageable);
        System.out.println(userPage);
    }

    //修改
    @Test
    public void updateUser() {
        User user = repository.findById("626e6ce5058c04067c09b50f").get();
        user.setName("张三_1");
        user.setAge(25);
        user.setEmail("883220990@qq.com");
        User save = repository.save(user);
        System.out.println(save);
    }

}
