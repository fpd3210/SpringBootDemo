package com.dpf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JpaApplication extends SpringBootServletInitializer {


    /**
     * servlet支持
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JpaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

}
