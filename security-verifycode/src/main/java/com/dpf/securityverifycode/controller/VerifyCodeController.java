package com.dpf.securityverifycode.controller;

import com.dpf.securityverifycode.utils.VerifyCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author dpf
 * @create 2020-04-23 17:40
 * @email 446933040@qq.com
 */
@RestController
public class VerifyCodeController {

    @GetMapping("/vercode")
    public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        String text = vc.getText();
        HttpSession session = req.getSession();
        session.setAttribute("index",text);
        VerifyCode.output(image,resp.getOutputStream());
    }




}

