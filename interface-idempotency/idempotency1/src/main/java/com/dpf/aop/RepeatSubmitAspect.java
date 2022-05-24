package com.dpf.aop;

import com.dpf.exception.RepeatSubmitException;
import com.dpf.token.TokenService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 通过aop拦截
 * @author Pikachues
 * Created 2022/5/23
 */
@Component
@Aspect
public class RepeatSubmitAspect {

    @Autowired
    private TokenService tokenService;

    @Pointcut(value = "@annotation(com.dpf.annotation.RepeatSubmit)")
    public void pc1(){

    }

    @Before(value = "pc1()")
    public void before(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            tokenService.checkToken(request);
        } catch (RepeatSubmitException e) {
            throw e;
        }
    }
}
