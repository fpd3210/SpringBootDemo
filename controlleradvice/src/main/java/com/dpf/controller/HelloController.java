package com.dpf.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.Set;

/**
 * @author dpf
 * @create 2020-01-04 16:08
 * @email 446933040@qq.com
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){

        int z = 10 / 0;
        return "success";
    }


    @GetMapping("/hello2")
    public String hello2(Model model){
        Map<String, Object> map = model.asMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet){
            System.out.println(map.get(key));
        }
        return "success";
    }
}
