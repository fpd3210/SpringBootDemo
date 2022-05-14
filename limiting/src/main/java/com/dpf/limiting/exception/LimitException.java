package com.dpf.limiting.exception;

/**
 * @author Pikachues
 * Created 2022/5/14
 */
public class LimitException extends RuntimeException{
    private String message;

    public LimitException(String message) {
        this.message = message;
    }
}
