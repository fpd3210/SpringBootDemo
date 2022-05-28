package com.dpf.springboottransaction.service.required;

import com.dpf.springboottransaction.pojo.Student;
import com.dpf.springboottransaction.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pikachues
 * Created 2022/5/27
 */
@Service
public class StudentService1 {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService2 studentService2;

    @Transactional
    public void update1(Student student) {
        student.setUserName("update1 required");
        studentRepository.save(student);

        studentService2.update2(student);
        int i = 10 / 0;
    }
}
