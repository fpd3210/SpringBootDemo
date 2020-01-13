package com.dpf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author dpf
 * @create 2020-01-05 17:07
 * @email 446933040@qq.com
 */
@Component
@Order(100)
public class MyCommandLineRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner2:"+ Arrays.toString(args));
    }
}
