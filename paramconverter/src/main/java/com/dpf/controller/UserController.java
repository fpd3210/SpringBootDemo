package com.dpf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author dpf
 * @create 2020-01-05 20:38
 * @email 446933040@qq.com
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello(Date date){
        System.out.println(date);
        return "success";
    }
}
