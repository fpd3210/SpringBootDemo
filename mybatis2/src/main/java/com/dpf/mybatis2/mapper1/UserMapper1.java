package com.dpf.mybatis2.mapper1;



import com.dpf.mybatis2.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper1 {
    List<User> getAllUsers();
}
