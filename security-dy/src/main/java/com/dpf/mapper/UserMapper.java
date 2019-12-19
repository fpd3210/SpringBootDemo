package com.dpf.mapper;

import com.dpf.bean.Role;
import com.dpf.bean.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


public interface UserMapper {

    List<Role> getRolesById(Integer id);

    User loadUserByUsername(String username);
}
