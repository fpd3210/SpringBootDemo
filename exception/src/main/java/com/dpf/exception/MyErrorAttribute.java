package com.dpf.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author dpf
 * @create 2020-01-04 17:47
 * @email 446933040@qq.com
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("myerror","自定义异常");
        return map;
    }
}
