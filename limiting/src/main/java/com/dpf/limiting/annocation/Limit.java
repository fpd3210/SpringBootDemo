package com.dpf.limiting.annocation;

import com.dpf.limiting.myenum.LimitType;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Pikachues
 * Created 2022/5/14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Limit {
    // 资源key
    String key() default "";

    // 最多访问次数
    int permitsPerSecond();

    // 时间 timeout内允许最多permitsPerSecond次
    long timeout();

    // 时间类型 秒
    TimeUnit timeunit() default TimeUnit.MILLISECONDS;

    // 提示信息
    String msg() default "系统繁忙,请稍后再试";

    LimitType limitType() default LimitType.DEFAULT;
}
