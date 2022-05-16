package com.dpf.limiting.aop;

import com.dpf.limiting.annocation.Limit;
import com.dpf.limiting.myenum.LimitType;
import com.dpf.limiting.utils.IpUtils;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Pikachues
 * Created 2022/5/14
 */
@Slf4j
@Aspect
@Component
public class LimitAspect {
    
    private final Map<String, RateLimiter> limitMap = Maps.newConcurrentMap();

    @Before("@annotation(limit)")
    public void doBefore(JoinPoint point, Limit limit) throws Throwable {
        int permitsPerSecond = limit.permitsPerSecond();
        //key作用：不同的接口，不同的流量控制
        String key = getCombineKey(limit, point);
        RateLimiter rateLimiter;
        //验证缓存是否有命中key
        if (!limitMap.containsKey(key)) {
            // 创建令牌桶
            rateLimiter = RateLimiter.create(limit.permitsPerSecond());
            limitMap.put(key, rateLimiter);
            //log.info("新建了令牌桶={}，容量={}", key, limit.permitsPerSecond());
            log.info("限制请求{}，当前请求数{},当前请求key:{}",permitsPerSecond,limitMap.size(),key);
        }
        rateLimiter = limitMap.get(key);
        // 拿令牌
        boolean acquire = rateLimiter.tryAcquire(limit.timeout(), limit.timeunit());
        // 拿不到命令，直接返回异常提示
        if (!acquire) {
            log.info("限制请求{}，当前请求数{},当前请求key:{}",permitsPerSecond,limitMap.size(),key);
            throw new RuntimeException(limit.msg());
        }
    }

    public String getCombineKey(Limit rateLimiter, JoinPoint point) {
        StringBuffer stringBuffer = new StringBuffer(rateLimiter.key());
        if (rateLimiter.limitType() == LimitType.IP) {
            stringBuffer.append(IpUtils.getIpAddr(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest())).append("-");
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        stringBuffer.append(targetClass.getName()).append("-").append(method.getName());
        return stringBuffer.toString();
    }
}
