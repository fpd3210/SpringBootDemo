package com.dpf.mongo;

import com.dpf.mongo.model.User;
import com.mongodb.client.result.DeleteResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Pikachues
 * Created 2022/5/1
 */
@SpringBootTest
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 增加
     */
    @Test
    public void add(){
        User user = new User();
        user.setAge(18);
        user.setName("zs");
        user.setEmail("124@qq.com");
        mongoTemplate.insert(user);
    }

    /**
     * 修改
     */
    @Test
    public void update(){
        Query query = new Query(Criteria.where("_id").is("626e6ce5058c04067c09b50f"));
        User dbUser = mongoTemplate.findById("626e6ce5058c04067c09b50f",User.class);
        dbUser.setName("lisi");
        dbUser.setAge(19);
        Update update = new Update();
        update.set("age",dbUser.getAge());
        update.set("name",dbUser.getName());
        mongoTemplate.updateFirst(query,update,User.class);
    }

    /**
     * 模糊查询
     */
    @Test
    public void findLikeList(){

        String name = "i";
        String regex = String.format("%s%s%s", "^.*", name, ".*$");
        System.out.println(regex);
        Pattern compile = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("name").regex(compile));

        List<User> users = mongoTemplate.find(query, User.class);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findByPage(){
        String name = "i";
        String regex = String.format("%s%s%s", "^.*", name, ".*$");
        System.out.println(regex);
        Pattern compile = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("name").regex(compile));

        Integer currentPage = 1;
        Integer pageSize = 3;

        int total = (int) mongoTemplate.count(query, User.class);
        List<User> users = mongoTemplate.find(query.skip((currentPage-1)*pageSize).limit(pageSize), User.class);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 删除
     */
    @Test
    public void delete(){
        Query query = new Query(Criteria.where("_id").is("626e70ae3581ef406512e6ce"));
        DeleteResult remove = mongoTemplate.remove(query, User.class);
        System.out.println(remove.getDeletedCount());
    }


}
