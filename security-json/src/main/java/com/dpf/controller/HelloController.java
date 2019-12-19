package com.dpf.controller;

import com.dpf.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpf
 * @create 2019-12-17 21:07
 * @email 446933040@qq.com
 */

@RestController
public class HelloController {
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录");
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
