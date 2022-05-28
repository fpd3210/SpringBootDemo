package com.dpf.springboottransaction.service.never;

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
public class StudentNeverService1 {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentNeverService2 studentNeverService2;

    @Transactional(rollbackFor = Exception.class)
    public void update1(Student student) {
        student.setUserName("update1 never");
        studentRepository.save(student);

        studentNeverService2.update2(student);
    }
}
