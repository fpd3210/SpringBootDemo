package com.lbh.chat.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hong
 * @Date 19-10-17
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final String DEFAULT_PASSWORD = "huyouni";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 处理密码
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        // 返回结果
        Map<String,Object> result = new HashMap<>();

        if(DEFAULT_PASSWORD.equals(password)){
            System.out.println(username + ":登录系统~~~");
            req.getSession().setAttribute("username",username);
            result.put("success",true);
        }else{
            result.put("success",false);
            result.put("message","账号或密码错误");
        }

        resp.getWriter().println(JSON.toJSONString(result));


    }
}
