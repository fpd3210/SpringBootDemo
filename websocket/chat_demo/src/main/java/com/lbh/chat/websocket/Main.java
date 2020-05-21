package com.lbh.chat.websocket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> targetPaths = new ArrayList<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

//        new File("e:\\code\\源码\\黑色官方版本源码\\后台\\videoadmin2(fastdfs)\\target").deleteOnExit();

        String dirPath = "/home/lbh/desktop/opt/code/源码/短域名";

        getTargetPaths(dirPath);
        delTargetDirs(targetPaths);

//        messageWriteFile();



    }

    /**
     * 删除日志写入路径
     * @throws IOException
     */
    private static void messageWriteFile() throws IOException {

        File logFile = new File("/home/lbh/desktop/opt/code/源码/短域名");

        BufferedWriter bw = new BufferedWriter(new FileWriter(logFile));

        bw.write(sb.toString());

        bw.close();
    }


    /**
     * 删除所有target文件夹
     * @param targetPath
     */
    private static void delTargetDirs(List<String> targetPaths) {


        for (String targetPath : targetPaths) {

            sb.append(targetPath + "\r\n");
            sb.append("------------------------------------------\r\n");

            deleteFile(targetPath);

        }

        System.out.println("清理成功");

    }

    /**
     * 根据target文件夹路径删除目录
     * @param targetPath
     */
    private static void deleteFile(String targetPath) {

        File targetPathFile = new File(targetPath);

        File[] targetFiles = targetPathFile.listFiles();

        for (File targetFile : targetFiles) {

            if(targetFile.isDirectory()){
                deleteFile(targetFile.getAbsolutePath());
            }else{
                String message = "正在删除" + targetFile.getName() + "文件,文件路径为" + targetFile.getAbsoluteFile();
                System.out.println(message);
                sb.append(message + "\r\n");
                targetFile.delete();
            }

        }

        targetPathFile.delete();


    }


    /**
     * 获取所有target绝对路径
     * @param dirPath
     */
    private static void getTargetPaths(String dirPath) {

        File dirPathFile = new File(dirPath);

        File[] files = dirPathFile.listFiles();

        for (File file : files) {

            if(file.isDirectory()){

                String path = file.getAbsolutePath();

                String pathName = path.substring(path.lastIndexOf("\\") + 1);

                if("target".equals(pathName)){
                    targetPaths.add(file.getAbsolutePath());
                }

                getTargetPaths(file.getAbsolutePath());
            }

        }

    }
}