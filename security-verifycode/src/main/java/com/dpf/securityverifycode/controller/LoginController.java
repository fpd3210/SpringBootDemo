package com.dpf.securityverifycode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpf
 * @create 2020-04-23 18:47
 * @email 446933040@qq.com
 */
@RestController
public class LoginController {
    

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/success1")
    public String success1(){
        return "success1";
    }

    @GetMapping("/success2")
    public String success2(){
        return "success2";
    }

    @GetMapping("/f1")
    public String f1(){
        return "f1";
    }

    @GetMapping("/f2")
    public String f2(){
        return "f2";
    }
}
