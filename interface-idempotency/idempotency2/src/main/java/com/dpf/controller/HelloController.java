package com.dpf.controller;

import com.dpf.annotation.RepeatSubmit;
import org.springframework.web.bind.annotation.*;

/**
 * @author Pikachues
 * Created 2022/5/23
 */
@RestController
public class HelloController {

    @PostMapping("/question")
    public Object question(@RequestBody String msg){
        return "question:"+msg;
    }

    @RepeatSubmit
    @GetMapping("/hello")
    public Object hello(){
        return "hello";
    }

}
