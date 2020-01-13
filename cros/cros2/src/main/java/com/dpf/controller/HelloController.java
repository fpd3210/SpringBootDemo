package com.dpf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpf
 * @create 2020-01-04 21:52
 * @email 446933040@qq.com
 */

@RestController
//@CrossOrigin("http://localhost:8081")
public class HelloController {

    //@CrossOrigin("http://localhost:8081")
    @GetMapping("/hello")
    public String hello(){
        return "hello cros";
    }


    @PutMapping("/doput")
    public String doput(){
        return "hello doput";
    }
}
