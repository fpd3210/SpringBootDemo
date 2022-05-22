package com.dpf.controller;

import com.dpf.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pikachues
 * Created 2022/5/22
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public Object hello(){
        helloService.hello();
        return "hello";
    }
}
