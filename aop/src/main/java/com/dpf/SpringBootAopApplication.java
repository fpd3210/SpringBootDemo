package com.dpf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAopApplication {

    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

}
