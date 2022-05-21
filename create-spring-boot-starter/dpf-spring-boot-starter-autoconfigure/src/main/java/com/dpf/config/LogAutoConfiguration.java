package com.dpf.config;


import com.dpf.interceptor.LogInterceptor;
import com.dpf.pojo.LogModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Pikachues
 * Created 2022/5/21
 */
@Configuration
@EnableConfigurationProperties(LogProperties.class)
public class LogAutoConfiguration implements WebMvcConfigurer {

    @Autowired
    private LogProperties logProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
    }

    @Bean
    public LogModule logModule(){
        LogModule logModule = new LogModule();
        logModule.setName(logProperties.getName());
        return logModule;
    }
}
