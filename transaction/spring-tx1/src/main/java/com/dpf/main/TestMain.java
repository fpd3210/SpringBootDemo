package com.dpf.main;

import com.dpf.service.StudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Pikachues
 * Created 2022/5/27
 */
public class TestMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.add2();
    }
}
