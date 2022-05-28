package com.dpf.springboottransaction.service.requiresnew;

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
public class StudentRequiresNewService1 {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentRequiresNewService2 studentRequiresNewService2;

    @Transactional(rollbackFor = Exception.class)
    public void update1(Student student) {
        student.setUserName("update1 RequiresNew");
        studentRepository.save(student);
        studentRequiresNewService2.update2(student);
        System.out.println("============================");
        int i = 10/0;
    }
}
