package com.dpf.send_redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 * 一次请求之后后台重定向  状态码302(临时重定向)-> url地址变为重定向地址
 * 二次请求目标重定向地址
 * @author Pikachues
 * Created 2022/6/1
 */
@Controller
public class RedirectController {
    @GetMapping("/redirect1")
    public String redirect1(){
        return "redirect:/redirect/handler";
    }

    @GetMapping("/redirect2")
    public void send2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/redirect/handler").forward(request,response);
    }

    @GetMapping("/redirect/handler")
    @ResponseBody
    public Object redirectHandler(){
        return "sendHandler";
    }
}
