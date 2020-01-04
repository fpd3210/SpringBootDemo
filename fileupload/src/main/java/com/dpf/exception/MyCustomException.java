package com.dpf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author dpf
 * @create 2020-01-03 18:00
 * @email 446933040@qq.com
 */
@ControllerAdvice
public class MyCustomException {

    //    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public void myexception(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter out = resp.getWriter();
//        out.write("上传文件大小超出限制!");
//        out.flush();
//        out.close();
//    }
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView myexception(MaxUploadSizeExceededException e) throws IOException {
        ModelAndView mv = new ModelAndView("myerror");
        mv.addObject("error", "上传文件大小超出限制！");
        return mv;
    }


    @ExceptionHandler(Exception.class)
    public ModelAndView myexception2(Exception e) throws IOException {
        ModelAndView mv = new ModelAndView("myerror");
        mv.addObject("error", "未知错误！");
        return mv;
    }
}
