package com.dpf.service;


import com.dpf.bean.Role;
import com.dpf.bean.User;
import com.dpf.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dpf
 * @create 2019-12-18 0:14
 * @email 446933040@qq.com
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在!");
        }
        List<Role> userRoles = userMapper.getUserRolesById(user.getId());
       for (Role r : userRoles){
           System.out.println(r.getName());
       }
        System.out.println("--------");
        user.setRoles(userRoles);
        return user;
    }
}
