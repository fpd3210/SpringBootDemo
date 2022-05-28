package com.dpf.jdbctemplate.service;

import com.dpf.jdbctemplate.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Pikachues
 * Created 2022/5/26
 */
@Service
public class HelloService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(User user){
        String sql = "insert into user(id,name) values(?,?)";
        jdbcTemplate.update(sql,user.getId(),user.getName());
    }

    public void update(User user){
        String sql = "update user set name=? where id=?";
        jdbcTemplate.update(sql,user.getId(),user.getName());
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from user where id=?",id );

    }

    public User select(int id){
        String sql = "select * from user where id=?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return users.get(0);
    }

}
