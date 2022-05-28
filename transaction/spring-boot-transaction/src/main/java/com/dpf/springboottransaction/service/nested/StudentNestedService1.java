package com.dpf.springboottransaction.service.nested;

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
public class StudentNestedService1 {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentNestedService2 studentNestedService2;

    @Transactional(rollbackFor = Exception.class)
    public void update1(Student student) {
        student.setUserName("update1 nested");
        studentRepository.save(student);
        studentNestedService2.update2(student);

    }
}
