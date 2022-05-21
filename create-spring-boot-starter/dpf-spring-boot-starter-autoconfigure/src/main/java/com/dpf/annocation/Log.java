package com.dpf.annocation;

import java.lang.annotation.*;

/**
 * @author Pikachues
 * Created 2022/5/21
 */
// 注解加在哪个地方
@Target(ElementType.METHOD)
// 什么时期生效
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /**
     * 接口方法的描述信息
     * @return
     */
   String desc() default "";
}
