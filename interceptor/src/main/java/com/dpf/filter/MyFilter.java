package com.dpf.filter;

import com.dpf.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Pikachues
 * Created 2022/5/22
 */
@Order(999)
@Component
public class MyFilter implements Filter {

    @Autowired
    private HelloService helloService;

    /**
     * 该方法在启动项目时会执行，只会执行一次
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter->init...");
        Filter.super.init(filterConfig);
    }

    /**
     * 每次请求时执行该方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter->doFilter....");
        // 过滤器链，让下一个过滤器执行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * 在项目停止时执行该方法
     */
    @Override
    public void destroy() {
        System.out.println("MyFilter->destroy...");
        Filter.super.destroy();
    }
}
