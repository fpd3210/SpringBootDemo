package com.dpf.utils;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dpf
 * @create 2020-01-04 16:18
 * @email 446933040@qq.com
 */

@ControllerAdvice
public class GlobalData {


    /**
     * 预设全局参数
     * @return
     */
    @ModelAttribute(value = "info")
    public Map<String,Object> mydata(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","pikachues");
        map.put("address","erunn");
        return map;
    }


    /**
     * 参数预处理
     * @param binder
     */
    @InitBinder("a")
    public void initA(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");
    }
    @InitBinder("b")
    public void initB(WebDataBinder binder){
        binder.setFieldDefaultPrefix("b.");
    }

}
