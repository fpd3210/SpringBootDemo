package com.dpf.springboottransaction.service.notsupported;

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
public class StudentNotSupportedService1 {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentNotSupportedService2 studentNotSupportedService2;

    @Transactional(rollbackFor = Exception.class)
    public void update1(Student student) {
        student.setUserName("update1 NotSuppor");
        studentRepository.save(student);
        int i = 10/0;
        studentNotSupportedService2.update2(student);
    }
}
