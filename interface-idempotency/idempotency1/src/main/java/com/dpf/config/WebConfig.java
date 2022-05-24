package com.dpf.config;

import com.dpf.interceptor.RepeatSubmitHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Pikachues
 * Created 2022/5/23
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RepeatSubmitHandlerInterceptor repeatSubmitHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(repeatSubmitHandlerInterceptor).addPathPatterns("/**");
    }
}
