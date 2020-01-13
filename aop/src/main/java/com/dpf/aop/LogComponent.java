package com.dpf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author dpf
 * @create 2020-01-05 21:09
 * @email 446933040@qq.com
 */
@Component
@Aspect
public class LogComponent {

    @Pointcut("execution(* com.dpf.service.*.*(..))")
    public void pc1(){
    }

    /**
     * 前置通知:在方法执行之前
     * @param jp
     */
    @Before(value = "pc1()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println("---before-->"+name);
    }

    /**
     * 后置通知:在方法执行之后
     * @param jp
     */
    @After(value = "pc1()")
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println("---after-->"+name);
    }

    /**
     * 返回通知:在方法正常结束后 返回结果之后执行
     * @param jp
     * @param result
     */
    @AfterReturning(value = "pc1()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        System.out.println("afterReturning----" + name + "-----result:" + result);
    }

    /**
     * 异常通知
     * @param jp
     * @param e
     */
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e) {
        String name = jp.getSignature().getName();
        System.out.println("afterThrowing---"+name+"----"+e.getMessage());
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object proceed = pjp.proceed();
        return "erunn";
    }



}
