package com.dpf.mybatis2.mapper2;

import com.dpf.mybatis2.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper2 {
    List<User> getAllUsers();
}
