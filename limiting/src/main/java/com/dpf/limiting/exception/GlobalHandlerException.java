package com.dpf.limiting.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author Pikachues
 * Created 2022/5/14
 */
@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Object exceptionHandler(Exception e){
        HashMap<Object, Object> result = new HashMap<>();
        result.put("msg",e.getMessage());
        return result;
    }
}
