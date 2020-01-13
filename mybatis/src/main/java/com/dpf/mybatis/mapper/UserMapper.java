package com.dpf.mybatis.mapper;



import com.dpf.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dpf
 * @create 2020-01-12 20:43
 * @email 446933040@qq.com
 */
@Mapper
public interface UserMapper {

    List<User> getAllUser();
}
