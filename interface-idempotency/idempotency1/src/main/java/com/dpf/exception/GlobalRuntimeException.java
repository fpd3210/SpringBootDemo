package com.dpf.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @author Pikachues
 * Created 2022/5/23
 */
@RestControllerAdvice
public class GlobalRuntimeException {

    @ExceptionHandler(value = RepeatSubmitException.class)
    public Object handlerRepeatSubmitException(RepeatSubmitException e){
        HashMap<String, Object> result = new HashMap<>();
        result.put("msg",e.getMessage());
        return result;
    }
}
