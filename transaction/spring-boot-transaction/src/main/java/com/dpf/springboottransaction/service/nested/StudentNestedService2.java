package com.dpf.springboottransaction.service.nested;

import com.dpf.springboottransaction.pojo.Student;
import com.dpf.springboottransaction.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pikachues
 * Created 2022/5/27
 */
public class StudentNestedService2 {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
    public void update2(Student student) {
        student.setUserName(student.getUserName() + " update2");
        studentRepository.save(student);
        int i = 10/0;
    }
}
