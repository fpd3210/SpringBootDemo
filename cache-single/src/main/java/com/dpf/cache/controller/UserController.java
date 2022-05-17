package com.dpf.cache.controller;

import com.dpf.cache.service.UserService;
import com.dpf.cache.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pikachues
 * Created 2022/5/17
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Object getUserList(){
        List<User> userList = userService.getUserList();
        Map<String,Object> result = new HashMap<>();
        result.put("data",userList);
        return result;
    }
}
