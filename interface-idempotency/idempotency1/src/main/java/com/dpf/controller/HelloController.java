package com.dpf.controller;

import com.dpf.annotation.RepeatSubmit;
import com.dpf.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pikachues
 * Created 2022/5/23
 */
@RestController
public class HelloController {

    @Autowired
    private TokenService tokenService;

    @RepeatSubmit
    @PostMapping("/hello1")
    public Object hello1(){
        return "hello1";
    }

    @PostMapping("/hello2")
    public Object hello2(){
        return "hello2";
    }

    @GetMapping("/getToken")
    public String getToken(){
        return tokenService.getToken();
    }
}
