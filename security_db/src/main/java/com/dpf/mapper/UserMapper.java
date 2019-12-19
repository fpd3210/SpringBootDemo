package com.dpf.mapper;

import com.dpf.bean.Role;
import com.dpf.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author dpf
 * @create 2019-12-18 0:14
 * @email 446933040@qq.com
 */
@Mapper
public interface UserMapper {
    User loadUserByUsername(@Param("username") String username);

    List<Role> getUserRolesById(Integer id);
}
