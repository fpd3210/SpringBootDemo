package com.dpf.springboottransaction;

import com.dpf.springboottransaction.pojo.Student;
import com.dpf.springboottransaction.service.StudentService;
import com.dpf.springboottransaction.service.mondatory.StudentMondatoryService1;
import com.dpf.springboottransaction.service.nested.StudentNestedService1;
import com.dpf.springboottransaction.service.never.StudentNeverService1;
import com.dpf.springboottransaction.service.notsupported.StudentNotSupportedService1;
import com.dpf.springboottransaction.service.required.StudentService1;
import com.dpf.springboottransaction.service.requiresnew.StudentRequiresNewService1;
import com.dpf.springboottransaction.service.support.StudentSupportService1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTransactionApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    void testAdd() {
        Student student = new Student();
        student.setId(2);
        student.setUserName("tom1");
        studentService.add(student);
    }

    @Autowired
    private StudentService1 studentService1;

    @Test
    public void testPropagationRequired(){
        Student student = new Student();
        student.setId(1);
        studentService1.update1(student);
    }


    @Autowired
    private StudentSupportService1 studentSupportService1;

    @Test
    public void testPropagationSupport(){
        Student student = new Student();
        student.setId(1);
        studentSupportService1.update1(student);
    }

    @Autowired
    private StudentMondatoryService1 studentMondatoryService1;

    @Test
    public void testPropagationMondatory(){
        Student student = new Student();
        student.setId(1);
        studentMondatoryService1.update1(student);
    }


    @Autowired
    private StudentRequiresNewService1 studentRequiresNewService1;
    @Test
    public void testPropagationRequiresNew(){
        Student student = new Student();
        student.setId(1);
        studentRequiresNewService1.update1(student);
    }


    @Autowired
    private StudentNotSupportedService1 studentNotSupportedService1;
    @Test
    public void testPropagationNotSupport(){
        Student student = new Student();
        student.setId(1);
        studentNotSupportedService1.update1(student);
    }

    @Autowired
    private StudentNeverService1 studentNeverService1;
    @Test
    public void testPropagationNever(){
        Student student = new Student();
        student.setId(1);
        studentNeverService1.update1(student);
    }


    @Autowired
    private StudentNestedService1 studentNestedService1;
    @Test
    public void testPropagationNested(){
        Student student = new Student();
        student.setId(1);
        studentNestedService1.update1(student);
    }

}
