package com.dpf.limiting.myenum;

/**
 * @author Pikachues
 * Created 2022/5/16
 */
public enum LimitType {
    /**
     * 默认策略全局限流
     */
    DEFAULT,
    /**
     * 根据请求者IP进行限流
     */
    IP
}
