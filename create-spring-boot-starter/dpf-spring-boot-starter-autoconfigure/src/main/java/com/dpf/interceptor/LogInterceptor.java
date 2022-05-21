package com.dpf.interceptor;

import com.dpf.annocation.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Pikachues
 * Created 2022/5/21
 */
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Log annotation = handlerMethod.getMethodAnnotation(Log.class);

            if (annotation != null) {
                long start = System.currentTimeMillis();
                threadLocal.set(start);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Log annotation = handlerMethod.getMethodAnnotation(Log.class);
            if (annotation != null) {
                String requestURI = request.getRequestURI();
                String methodName = method.getDeclaringClass().getName()+"#"+method.getName();

                long end = System.currentTimeMillis();
                long dur = end - threadLocal.get();
                log.info("请求路径{},请求方法名{},请求描述{},请求时间{}",requestURI,methodName,annotation.desc(),dur);
                threadLocal.remove();
            }
        }
    }
}
