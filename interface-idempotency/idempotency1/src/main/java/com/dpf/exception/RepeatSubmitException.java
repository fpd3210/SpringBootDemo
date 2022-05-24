package com.dpf.exception;

/**
 * @author Pikachues
 * Created 2022/5/23
 */
public class RepeatSubmitException extends RuntimeException{
    public RepeatSubmitException(String message) {
        super(message);
    }
}
