package com.dpf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面
 * @author Pikachues
 * Created 2022/5/22
 */
@Component
@Aspect // 标明当前类是一个切面
public class LogAspect {

    /**
     * 切点：要添加代码的地方，称作切点
     * 第一个 * 方法修饰符
     * 倒数第二个 * 所有类
     * 倒数第一个 * 所有方法
     * .. 方法中匹配不定参数
     */
    @Pointcut("execution(* com.dpf.service.*.*(..))")
    public void pc1(){

    }

    /**
     * 前置通知，方法调用之前执行
     * @param joinPoint
     */
    @Before(value = "pc1()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("--->before--->方法名："+methodName);
    }

    /**
     * 后置通知，方法执行之后执行
     * @param joinPoint
     */
    @After(value = "execution(* com.dpf.service.*.*(..))")
    public void after(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("--->after--->方法名："+methodName);
    }

    /**
     * 返回通知，在方法放回之后执行
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pc1()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("--->after--->方法名："+methodName+"--->返回值:"+result);
    }

    /**
     * 异常通知，在抛出异常后通知
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("--->after--->方法名："+methodName+"--->异常消息:"+e.getMessage());
    }

    @Around(value = "pc1()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try {
            String methodName = joinPoint.getSignature().getName();
            System.out.println(methodName+"---->环绕通知开始....");
            //这个相当于 method.invoke 方法，我们可以在这个方法的前后分别添加日志，就相当于是前置/后置通知
            proceed = joinPoint.proceed();
            System.out.println(methodName+"---->环绕通知结束....");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return proceed;
    }





}
