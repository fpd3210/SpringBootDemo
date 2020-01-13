package com.dpf.service;

import org.springframework.stereotype.Service;

/**
 * @author dpf
 * @create 2020-01-05 21:08
 * @email 446933040@qq.com
 */
@Service
public class UserService {
    public String getUsernameById(Integer id) {
        System.out.println("getUsernameById");
        return "pikachues";
    }

    public void deleteUserById(Integer id) {
        System.out.println("deleteUserById");
    }
}
