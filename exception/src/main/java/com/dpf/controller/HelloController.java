package com.dpf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpf
 * @create 2020-01-04 17:44
 * @email 446933040@qq.com
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        int i = 1 / 0;
        return "success";
    }
}
