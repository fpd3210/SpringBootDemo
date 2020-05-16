package com.dpf.securityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpf
 * @create 2020-05-16 14:58
 * @email 446933040@qq.com
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello jwt !";
    }
    @GetMapping("/admin")
    public String admin() {
        return "hello admin !";
    }
}
