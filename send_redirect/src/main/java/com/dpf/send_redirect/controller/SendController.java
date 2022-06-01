package com.dpf.send_redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发，后台中转发到另外一个接口进行处理，状态码不发生改变
 * @author Pikachues
 * Created 2022/6/1
 */
@Controller
public class SendController {

    @GetMapping("/send1")
    public String send1(){
        return "forward:/send/handler";
    }

    @GetMapping("/send2")
    public void send2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/send/handler").forward(request,response);
    }

    @GetMapping("/send/handler")
    @ResponseBody
    public Object sendHandler(){
        return "sendHandler";
    }
}
