package com.dpf.config;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author dpf
 * @create 2020-01-05 20:47
 * @email 446933040@qq.com
 */
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
