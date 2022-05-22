package com.dpf.config;

import com.dpf.interceptor.MyHandlerInterceptor;
import com.dpf.interceptor.MyHandlerInterceptor2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dpf
 * @create 2020-01-05 16:52
 * @email 446933040@qq.com
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyHandlerInterceptor()).addPathPatterns("/**").order(99);
        registry.addInterceptor(getMyHandlerInterceptor2()).addPathPatterns("/**").order(9);
    }

    /**
     * 拦截器建议使用@Bean的方式注入而不是用new MyHandlerInterceptor，不然在拦截器中使用@AutoWire会报空指针
     * @return
     */
    @Bean
    MyHandlerInterceptor getMyHandlerInterceptor(){
        return new MyHandlerInterceptor();
    }

    @Bean
    MyHandlerInterceptor2 getMyHandlerInterceptor2(){
        return new MyHandlerInterceptor2();
    }

}
