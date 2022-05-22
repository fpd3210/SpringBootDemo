package com.dpf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpf
 * @create 2020-01-05 16:54
 * @email 446933040@qq.com
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){

        System.out.println("controller hello 执行中");
        return "hello";
    }


}
