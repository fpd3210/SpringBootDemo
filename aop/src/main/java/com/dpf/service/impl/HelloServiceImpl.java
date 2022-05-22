package com.dpf.service.impl;

import com.dpf.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author Pikachues
 * Created 2022/5/22
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void hello() {
        //throw new RuntimeException("异常信息");
        System.out.println("HelloServiceImpl-->hello 执行中");
    }
}
