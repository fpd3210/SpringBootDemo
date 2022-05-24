package com.dpf.config;

import com.dpf.interceptor.QuestionInterceptor;
import com.dpf.interceptor.RepeatSubmitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Pikachues
 * Created 2022/5/23
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private QuestionInterceptor questionInterceptor;

    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**");
    }
}
