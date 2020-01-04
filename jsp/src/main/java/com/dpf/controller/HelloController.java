package com.dpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dpf
 * @create 2019-12-26 22:47
 * @email 446933040@qq.com
 */
@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello(Model model, String name) {
        model.addAttribute("name", name);
        return "hello";
    }

}
