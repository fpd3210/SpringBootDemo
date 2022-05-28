package com.dpf.springboottransaction.service.required;

import com.dpf.springboottransaction.pojo.Student;
import com.dpf.springboottransaction.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pikachues
 * Created 2022/5/27
 */
@Service
public class StudentService2 {
    @Autowired
    private StudentRepository studentRepository;


    public void update2(Student student) {
        student.setUserName(student.getUserName() + "update2");
        studentRepository.save(student);
        int i = 10 / 0;
    }
}
