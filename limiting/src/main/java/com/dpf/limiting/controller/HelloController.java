package com.dpf.limiting.controller;

import com.dpf.limiting.annocation.Limit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pikachues
 * Created 2022/5/14
 */
@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    @Limit(key = "hello",permitsPerSecond = 1,timeout = 1)
    public Object hello(){
        log.info("请求到接口");
        return "hello";
    }


}
