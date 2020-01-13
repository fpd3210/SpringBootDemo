package com.dpf.mybatis.mapper;

import com.dpf.mybatis.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author dpf
 * @create 2020-01-12 21:17
 * @email 446933040@qq.com
 */
@Mapper
public interface UserMapper2 {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "address", column = "a")
    })
    @Select(value = "select * from user")
    List<User> getAllUser();
}
