package com.dpf.interceptor;

import com.dpf.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dpf
 * @create 2020-01-05 16:49
 * @email 446933040@qq.com
 */
@Order(99999)
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private HelloService helloService;

    /**
     * 请求到达Controller之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("MyInterceptor-->preHandle");

        return true;
    }

    /**
     * 请求到达Controller之后，在DispatcherServlet视图渲染之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor-->postHandle");
    }

    /**
     * preHandle返回true才会执行
     * 在整个请求结束之后， DispatcherServlet 渲染了对应的视图之后执行。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor-->afterCompletion");
    }
}
