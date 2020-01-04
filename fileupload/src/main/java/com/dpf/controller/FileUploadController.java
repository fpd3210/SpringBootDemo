package com.dpf.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author dpf
 * @create 2020-01-03 17:59
 * @email 446933040@qq.com
 */
@RestController
public class FileUploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");


    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest req){
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/img") + format;

        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }

        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

        try {
            file.transferTo(new File(folder,newName));
            String url = req.getScheme() + "://" + req.getServerName() + ":" +req.getServerPort() + "/img" + format + newName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }


    @PostMapping("/uploads")
    public String uploads(MultipartFile [] files, HttpServletRequest req){
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/img") + format;

        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }

        for (MultipartFile file : files) {
            String oldName = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

            try {
                file.transferTo(new File(folder,newName));
                String url = req.getScheme() + "://" + req.getServerName() + ":" +req.getServerPort() + "/img" + format + newName;
                System.out.println(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return "error";
    }



























}
