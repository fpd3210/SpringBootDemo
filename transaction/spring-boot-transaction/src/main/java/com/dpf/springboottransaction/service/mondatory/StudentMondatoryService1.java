package com.dpf.springboottransaction.service.mondatory;

import com.dpf.springboottransaction.pojo.Student;
import com.dpf.springboottransaction.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pikachues
 * Created 2022/5/27
 */
@Service
public class StudentMondatoryService1 {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMondatoryService2 studentMondatoryService2;

    //@Transactional(rollbackFor = Exception.class)
    public void update1(Student student) {
        student.setUserName("update1 Mondatory");
        studentRepository.save(student);

        studentMondatoryService2.update2(student);
    }
}
