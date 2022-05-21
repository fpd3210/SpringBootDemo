package com.dpf.controller;

import com.dpf.annocation.Log;
import com.dpf.pojo.LogModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pikachues
 * Created 2022/5/21
 */
@RestController
public class HelloController {


    @Autowired
    private LogModule logModule;

    @Log(desc = "日志注解")
    @GetMapping("/hello")
    public Object hello(){

        return "hello"+logModule.getName();
    }
}
