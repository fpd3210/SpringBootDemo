package com.dpf.controller;

import com.dpf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpf
 * @create 2020-01-05 21:08
 * @email 446933040@qq.com
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/test1")
    public String getUsernameById(Integer id) {
        return userService.getUsernameById(id);
    }

    @GetMapping("/test2")
    public void deleteUserById(Integer id) {
        userService.deleteUserById(id);
    }
}
